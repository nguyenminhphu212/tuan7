
import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {

        QuanLyHangHoa ql = new QuanLyHangHoa(10);

        HangHoa h1 = new HangHoa(
            "TP002", "CA PHE", "TRUNG NGUYEN",
            150, 45, LocalDate.of(2026, 9, 15)
        );

        HangHoa h2 = new HangHoa(
            "TP202", "BANH MI", "ABC",
            250, 15, LocalDate.of(2026, 9, 20)
        );

        // Them
        System.out.println("Them h1: " + ql.addHangHoa(h1));
        System.out.println("Them h2: " + ql.addHangHoa(h2));

        System.out.println("\n=== DANH SACH BAN DAU ===");
        ql.inDS();

        // Tim kiem
        System.out.println("\n=== TIM KIEM ===");
        HangHoa kq = ql.timTheoMa("TP002");

        if (kq != null) {
            System.out.println(kq);
        } else {
            System.out.println("Khong tim thay!");
        }

        // Sua don gia
        System.out.println("\n=== SUA DON GIA ===");
        System.out.println(ql.suaDonGia("TP002", 600));

        ql.inDS();

        // Xoa
        System.out.println("\n=== XOA HANG HOA ===");
        System.out.println(ql.xoaHHID("TP002"));

        ql.inDS();
    }
}
