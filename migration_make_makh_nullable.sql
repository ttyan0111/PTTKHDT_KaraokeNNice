-- ============================================
-- Migration Script: Make MaKH nullable in PhieuDatPhong
-- Allow walk-in guests without customer ID
-- ============================================

-- Make MaKH column nullable
ALTER TABLE PhieuDatPhong 
MODIFY COLUMN MaKH INT NULL;

-- Add index for date queries (performance optimization)
CREATE INDEX IF NOT EXISTS idx_phieu_dat_ngay_dat 
ON PhieuDatPhong(NgayDat);

-- Add index for customer queries
CREATE INDEX IF NOT EXISTS idx_phieu_dat_ma_kh 
ON PhieuDatPhong(MaKH);

-- Verify changes
SELECT 
    COLUMN_NAME,
    IS_NULLABLE,
    DATA_TYPE,
    COLUMN_KEY
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_SCHEMA = 'pttkhdt_karaoke_nnice'
  AND TABLE_NAME = 'PhieuDatPhong'
  AND COLUMN_NAME IN ('MaKH', 'NgayDat');

-- Show sample data
SELECT * FROM PhieuDatPhong LIMIT 5;
