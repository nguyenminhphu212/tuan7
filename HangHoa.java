import java.time.LocalDate;

public class HangHoa {

    private String maHang;
    private String tenHang;
    private String hangSX;
    private double giaBan;
    private float soLuongTon;
    private LocalDate ngayNhapHang;

    // Constructor 1
    public HangHoa(String maHang) {

        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma hang khong duoc de trong!");
        }

        this.maHang = maHang;
        this.tenHang = "xxx";
        this.hangSX = "xxx";
        this.giaBan = 0;
        this.soLuongTon = 0;
        this.ngayNhapHang = LocalDate.now();
    }

    // Constructor 2
    public HangHoa(String maHang, String tenHang, String hangSX,
            double giaBan, float soLuongTon, LocalDate ngayNhapHang) {

        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma hang khong duoc de trong!");
        }

        if (tenHang == null || tenHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Ten hang khong duoc de trong!");
        }

        if (hangSX == null || hangSX.trim().isEmpty()) {
            throw new IllegalArgumentException("Hang san xuat khong duoc de trong!");
        }

        if (giaBan < 0 || !Double.isFinite(giaBan)) {
            throw new IllegalArgumentException("Gia ban phai >= 0!");
        }

        if (soLuongTon < 0 || !Float.isFinite(soLuongTon)) {
            throw new IllegalArgumentException("So luong ton phai >= 0!");
        }

        if (ngayNhapHang == null) {
            throw new IllegalArgumentException("Ngay nhap hang khong duoc null!");
        }

        if (ngayNhapHang.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngay nhap hang khong duoc o tuong lai!");
        }

        this.maHang = maHang;
        this.tenHang = tenHang;
        this.hangSX = hangSX;
        this.giaBan = giaBan;
        this.soLuongTon = soLuongTon;
        this.ngayNhapHang = ngayNhapHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        if (maHang != null && !maHang.trim().isEmpty()) {
            this.maHang = maHang;
        }
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang != null && !tenHang.trim().isEmpty()) {
            this.tenHang = tenHang;
        }
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        if (hangSX != null && !hangSX.trim().isEmpty()) {
            this.hangSX = hangSX;
        }
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        if (giaBan >= 0 && Double.isFinite(giaBan)) {
            this.giaBan = giaBan;
        }
    }

    public float getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(float soLuongTon) {
        if (soLuongTon >= 0 && Float.isFinite(soLuongTon)) {
            this.soLuongTon = soLuongTon;
        }
    }

    public LocalDate getNgayNhapHang() {
        return ngayNhapHang;
    }

    public void setNgayNhapHang(LocalDate ngayNhapHang) {
        if (ngayNhapHang != null
                && !ngayNhapHang.isAfter(LocalDate.now())) {
            this.ngayNhapHang = ngayNhapHang;
        }
    }

    // Tinh tong gia tri hang ton kho
    public double tinhTongGiaTri() {
        return getGiaBan() * getSoLuongTon();
    }

    @Override
    public String toString() {

        return String.format(
            "Ma Hang: %s | Ten Hang: %s | Hang SX: %s | Gia Ban: %.2f | So Luong Ton: %.2f | Ngay Nhap Hang: %s | Tong Gia Tri: %.2f",
            maHang, tenHang, hangSX, giaBan,
            soLuongTon, ngayNhapHang, tinhTongGiaTri()
        );
    }
}