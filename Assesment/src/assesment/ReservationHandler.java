/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assesment;

/**
 *
 * @author Sandaruwan
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

public class ReservationHandler implements Runnable {

    private String userId;
    private String seatNumber;
    private DB db;
    private JCheckBox[] checkBoxes;
    private JLabel[] seatLabels;

    public ReservationHandler(String userId, String seatNumber, DB db, JCheckBox[] checkBoxes, JLabel[] seatLabels) {
        this.userId = userId;
        this.seatNumber = seatNumber;
        this.db = db;
        this.checkBoxes = checkBoxes;
        this.seatLabels = seatLabels;
    }

    @Override
    public void run() {
        if (isSeatAvailable(seatNumber)) {
            reserveSeat();
            updateGUI(seatNumber);
        } else {
            System.out.println("Seat " + seatNumber + " is already reserved.");
        }
    }

    boolean isSeatAvailable(String seatNumber) {
        boolean available = true;
        try (Connection con = db.getCon();
                PreparedStatement pstmt = con.prepareStatement("SELECT * FROM reservations WHERE seat_number = ?")) {
            pstmt.setString(1, seatNumber);
            try (ResultSet rs = pstmt.executeQuery()) {
                available = !rs.next(); // If there are no results, the seat is available
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return available;
    }

    void updateGUI(String seatNumber) {
        int seatIndex = Integer.parseInt(seatNumber) - 1;
        checkBoxes[seatIndex].setSelected(true);
        seatLabels[seatIndex].setText("Reserved");
        checkBoxes[seatIndex].setEnabled(false); // Disable checkbox so it cannot be unchecked
    }

    private void reserveSeat() {
        try (Connection con = db.getCon();
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO reservations (user_id, seat_number) VALUES (?, ?)")) {
            pstmt.setString(1, userId);
            pstmt.setString(2, seatNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

