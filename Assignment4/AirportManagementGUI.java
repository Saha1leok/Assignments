import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AirportManagementGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Airport Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Airport", createAirportPanel());
        tabbedPane.addTab("Aircraft", createAircraftPanel());
        tabbedPane.addTab("Passenger", createPassengerPanel());

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    //  Airport Panel
    private static JPanel createAirportPanel() {
        JPanel airportPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        JLabel airportIdLabel = new JLabel("Airport ID:");
        JTextField airportIdField = new JTextField();
        JLabel airportNameLabel = new JLabel("Airport Name:");
        JTextField airportNameField = new JTextField();

        JButton addAirportButton = new JButton("Add Airport");
        JButton deleteAirportButton = new JButton("Delete Airport");
        JButton updateAirportButton = new JButton("Update Airport");

        inputPanel.add(airportIdLabel);
        inputPanel.add(airportIdField);
        inputPanel.add(airportNameLabel);
        inputPanel.add(airportNameField);
        inputPanel.add(addAirportButton);
        inputPanel.add(deleteAirportButton);
        inputPanel.add(updateAirportButton);

        DefaultTableModel airportTableModel = new DefaultTableModel(new String[]{"ID", "Name"}, 0);
        JTable airportTable = new JTable(airportTableModel);
        JScrollPane tableScrollPane = new JScrollPane(airportTable);

        airportPanel.add(inputPanel, BorderLayout.NORTH);
        airportPanel.add(tableScrollPane, BorderLayout.CENTER);

        loadAirports(airportTableModel);

        addAirportButton.addActionListener(e -> addRecord(airportIdField, airportNameField, "Airport", airportTableModel));
        deleteAirportButton.addActionListener(e -> deleteRecord(airportIdField, "Airport", airportTableModel));
        updateAirportButton.addActionListener(e -> updateRecord(airportIdField, airportNameField, "Airport", airportTableModel));

        return airportPanel;
    }

    private static void loadAirports(DefaultTableModel airportTableModel) {
        loadRecords("Airport", airportTableModel);
    }

    // Aircraft Panel
    private static JPanel createAircraftPanel() {
        JPanel aircraftPanel = new JPanel(new BorderLayout());


        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel aircraftIdLabel = new JLabel("Aircraft ID:");
        JTextField aircraftIdField = new JTextField();
        JLabel aircraftModelLabel = new JLabel("Aircraft Model:");
        JTextField aircraftModelField = new JTextField();
        JLabel maxPassengersLabel = new JLabel("Max Passengers:");
        JTextField maxPassengersField = new JTextField();

        inputPanel.add(aircraftIdLabel);
        inputPanel.add(aircraftIdField);
        inputPanel.add(aircraftModelLabel);
        inputPanel.add(aircraftModelField);
        inputPanel.add(maxPassengersLabel);
        inputPanel.add(maxPassengersField);


        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton addAircraftButton = new JButton("Add Aircraft");
        JButton deleteAircraftButton = new JButton("Delete Aircraft");
        JButton updateAircraftButton = new JButton("Update Aircraft");

        buttonPanel.add(addAircraftButton);
        buttonPanel.add(deleteAircraftButton);
        buttonPanel.add(updateAircraftButton);


        DefaultTableModel aircraftTableModel = new DefaultTableModel(new String[]{"ID", "Model", "Max Passengers"}, 0);
        JTable aircraftTable = new JTable(aircraftTableModel);
        JScrollPane tableScrollPane = new JScrollPane(aircraftTable);


        aircraftPanel.add(inputPanel, BorderLayout.NORTH);
        aircraftPanel.add(buttonPanel, BorderLayout.SOUTH);
        aircraftPanel.add(tableScrollPane, BorderLayout.CENTER);


        loadAircrafts(aircraftTableModel);


        addAircraftButton.addActionListener(e -> addAircraft(aircraftIdField, aircraftModelField, maxPassengersField, aircraftTableModel));
        deleteAircraftButton.addActionListener(e -> deleteRecord(aircraftIdField, "Aircraft", aircraftTableModel));
        updateAircraftButton.addActionListener(e -> updateAircraft(aircraftIdField, aircraftModelField, maxPassengersField, aircraftTableModel));

        return aircraftPanel;
    }
    private static void addAircraft(JTextField idField, JTextField modelField, JTextField maxPassengersField, DefaultTableModel tableModel) {
        String id = idField.getText();
        String model = modelField.getText();
        String maxPassengers = maxPassengersField.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO Aircraft (id, model, max_passengers) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, model);
            stmt.setInt(3, Integer.parseInt(maxPassengers));
            stmt.executeUpdate();


            tableModel.addRow(new Object[]{id, model, maxPassengers});
            JOptionPane.showMessageDialog(null, "Aircraft added successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error adding aircraft: " + ex.getMessage());
        }
    }
    private static void updateAircraft(JTextField idField, JTextField modelField, JTextField maxPassengersField, DefaultTableModel tableModel) {
        String id = idField.getText();
        String model = modelField.getText();
        String maxPassengers = maxPassengersField.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "UPDATE Aircraft SET model = ?, max_passengers = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, model);
            stmt.setInt(2, Integer.parseInt(maxPassengers));
            stmt.setString(3, id);
            stmt.executeUpdate();


            loadAircrafts(tableModel);
            JOptionPane.showMessageDialog(null, "Aircraft updated successfully.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating aircraft: " + ex.getMessage());
        }
    }


    private static void loadAircrafts(DefaultTableModel tableModel) {
        tableModel.setRowCount(0); // Очистить таблицу

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT id, model, max_passengers FROM Aircraft";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id");
                String model = rs.getString("model");
                int maxPassengers = rs.getInt("max_passengers");
                tableModel.addRow(new Object[]{id, model, maxPassengers});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading aircrafts: " + ex.getMessage());
        }
    }


    //  Passenger Panel
    private static JPanel createPassengerPanel() {
        JPanel passengerPanel = new JPanel(new BorderLayout());


        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel passengerIdLabel = new JLabel("Passenger ID:");
        JTextField passengerIdField = new JTextField();

        JLabel passengerNameLabel = new JLabel("Passenger Name:");
        JTextField passengerNameField = new JTextField();

        JLabel passengerAgeLabel = new JLabel("Age:");
        JTextField passengerAgeField = new JTextField();

        JLabel passengerSeatLabel = new JLabel("Seat Number:");
        JTextField passengerSeatField = new JTextField();

        inputPanel.add(passengerIdLabel);
        inputPanel.add(passengerIdField);
        inputPanel.add(passengerNameLabel);
        inputPanel.add(passengerNameField);
        inputPanel.add(passengerAgeLabel);
        inputPanel.add(passengerAgeField);
        inputPanel.add(passengerSeatLabel);
        inputPanel.add(passengerSeatField);


        DefaultTableModel passengerTableModel = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Seat"}, 0);
        JTable passengerTable = new JTable(passengerTableModel);
        JScrollPane tableScrollPane = new JScrollPane(passengerTable);


        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));

        JButton addPassengerButton = new JButton("Add");
        JButton deletePassengerButton = new JButton("Delete");
        JButton updatePassengerButton = new JButton("Update");
        JButton searchPassengerButton = new JButton("Search");

        buttonPanel.add(addPassengerButton);
        buttonPanel.add(deletePassengerButton);
        buttonPanel.add(updatePassengerButton);
        buttonPanel.add(searchPassengerButton);


        passengerPanel.add(inputPanel, BorderLayout.NORTH);
        passengerPanel.add(tableScrollPane, BorderLayout.CENTER);
        passengerPanel.add(buttonPanel, BorderLayout.SOUTH);


        loadPassengers(passengerTableModel);


        addPassengerButton.addActionListener(e -> addPassenger(passengerIdField, passengerNameField, passengerAgeField, passengerSeatField, passengerTableModel));
        deletePassengerButton.addActionListener(e -> deleteRecord(passengerIdField, "Passenger", passengerTableModel));
        updatePassengerButton.addActionListener(e -> updatePassenger(passengerIdField, passengerNameField, passengerAgeField, passengerSeatField, passengerTableModel));
        searchPassengerButton.addActionListener(e -> searchRecord(passengerIdField, passengerTable));

        return passengerPanel;
    }

    private static void loadPassengers(DefaultTableModel passengerTableModel) {
        passengerTableModel.setRowCount(0);
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Passenger";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                passengerTableModel.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("seat_number")
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void addPassenger(JTextField idField, JTextField nameField, JTextField ageField, JTextField seatField, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String ageStr = ageField.getText().trim();
        String seat = seatField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || ageStr.isEmpty() || seat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageStr);
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "INSERT INTO Passenger (id, name, age, seat_number) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, Integer.parseInt(id));
                stmt.setString(2, name);
                stmt.setInt(3, age);
                stmt.setString(4, seat);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Passenger added successfully!");
                loadPassengers(tableModel);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Age must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding passenger: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void updatePassenger(JTextField idField, JTextField nameField, JTextField ageField, JTextField seatField, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String ageStr = ageField.getText().trim();
        String seat = seatField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || ageStr.isEmpty() || seat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int age = Integer.parseInt(ageStr);
            try (Connection conn = DatabaseConnection.getConnection()) {
                String query = "UPDATE Passenger SET name = ?, age = ?, seat_number = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, seat);
                stmt.setInt(4, Integer.parseInt(id));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Passenger updated successfully!");
                loadPassengers(tableModel);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Age must be a number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating passenger: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Common Methods
    private static void loadRecords(String tableName, DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM " + tableName;
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getInt("id"), rs.getString("name")});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void addRecord(JTextField idField, JTextField nameField, String tableName, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        if (id.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Both ID and Name are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO " + tableName + " (id, name) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.setString(2, name);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record added successfully!");
            loadRecords(tableName, tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error adding record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void deleteRecord(JTextField idField, String tableName, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID is required for deletion.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM " + tableName + " WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record deleted successfully!");
            loadRecords(tableName, tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error deleting record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void updateRecord(JTextField idField, JTextField nameField, String tableName, DefaultTableModel tableModel) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        if (id.isEmpty() || name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Both ID and Name are required for update.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "UPDATE " + tableName + " SET name = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, Integer.parseInt(id));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record updated successfully!");
            loadRecords(tableName, tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error updating record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void searchRecord(JTextField idField, JTable table) {
        String id = idField.getText().trim();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID is required for search.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getValueAt(i, 0).toString().equals(id)) {
                table.setRowSelectionInterval(i, i);
                table.scrollRectToVisible(table.getCellRect(i, 0, true));
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Record not found.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
