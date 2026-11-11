import java.util.Arrays;

public class QuanLyHangHoa {

    private HangHoa[] ds;
    private int count;

    public QuanLyHangHoa(int n) {

        if (n <= 0) {
            n = 10;
        }

        ds = new HangHoa[n];
        count = 0;
    }

    // Them hang hoa
    public boolean addHangHoa(HangHoa s) {

        if (s == null || timTheoMa(s.getMaHang()) != null) {
            return false;
        }

        if (count == ds.length) {
            ds = Arrays.copyOf(ds, ds.length * 2);
        }

        ds[count] = s;
        count++;

        return true;
    }

    // Tim theo ma hang
    public HangHoa timTheoMa(String maHang) {

        if (maHang == null || maHang.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < count; i++) {

            if (ds[i].getMaHang().equalsIgnoreCase(maHang)) {
                return ds[i];
            }
        }

        return null;
    }

    // Xoa hang hoa theo ma
    public boolean xoaHHID(String maHang) {

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (ds[i].getMaHang().equalsIgnoreCase(maHang)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false;
        }

        for (int i = index; i < count - 1; i++) {
            ds[i] = ds[i + 1];
        }

        ds[count - 1] = null;
        count--;

        return true;
    }

    // Sua don gia
    public boolean suaDonGia(String maHang, double donGiaMoi) {

        HangHoa s = timTheoMa(maHang);

        if (s == null || donGiaMoi < 0
                || !Double.isFinite(donGiaMoi)) {
            return false;
        }

        s.setGiaBan(donGiaMoi);

        return true;
    }

    // In danh sach
    public void inDS() {

        if (count == 0) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(ds[i]);
        }
    }

    // Lay so luong hang hoa
    public int getCount() {
        return count;
    }
}