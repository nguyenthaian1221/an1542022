package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;

public class QLSVView extends JFrame {

	public QLSVModel model;

	private JPanel contentPane;
	public JTextField textField_MaThiSinh_timKiem;
	public JTable table;
	public JTextField textField_MaThiSinh;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;

	public ButtonGroup btn_gioiTinh;

	public JComboBox comboBox_QueQuan;

	public JComboBox comboBox_queQuan_timKiem;

	public JRadioButton rdbtnNam;

	public JRadioButton rdbtnNu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QLSVView frame = new QLSVView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 624);
		ActionListener action = new QLSVController(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);

		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);

		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuFile.add(menuExit);

		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuBar.add(menuAbout);

		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.addActionListener(action);

		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelQueQuan = new JLabel("Qu\u00EA qu\u00E1n");
		labelQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelQueQuan.setBounds(10, 11, 111, 50);
		contentPane.add(labelQueQuan);

		JLabel label_MaThiSinh_timKiem = new JLabel("M\u00E3 Th\u00ED Sinh");
		label_MaThiSinh_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_MaThiSinh_timKiem.setBounds(223, 11, 186, 50);
		contentPane.add(label_MaThiSinh_timKiem);

		textField_MaThiSinh_timKiem = new JTextField();
		textField_MaThiSinh_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_MaThiSinh_timKiem.setColumns(10);
		textField_MaThiSinh_timKiem.setBounds(341, 22, 112, 29);
		contentPane.add(textField_MaThiSinh_timKiem);

		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTim.setBounds(471, 19, 111, 29);
		contentPane.add(btnTim);
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem = new JComboBox();
		comboBox_queQuan_timKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());

		}
		comboBox_queQuan_timKiem.setBounds(102, 29, 111, 22);
		contentPane.add(comboBox_queQuan_timKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 59, 716, 2);
		contentPane.add(separator_1);

		JLabel lblNewLabel = new JLabel("Danh s\u00E1ch th\u00ED sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 68, 156, 22);
		contentPane.add(lblNewLabel);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 th\u00ED sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ng\u00E0y sinh",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));

		table.setRowHeight(30);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(3, 101, 694, 170);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 280, 716, 2);
		contentPane.add(separator_1_1);

		JLabel lblThngTinTh = new JLabel("Th\u00F4ng tin th\u00ED sinh");
		lblThngTinTh.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblThngTinTh.setBounds(10, 285, 210, 38);
		contentPane.add(lblThngTinTh);

		JLabel label_ID = new JLabel("M\u00E3 Th\u00ED Sinh");
		label_ID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_ID.setBounds(10, 320, 186, 50);
		contentPane.add(label_ID);

		textField_MaThiSinh = new JTextField();
		textField_MaThiSinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_MaThiSinh.setColumns(10);
		textField_MaThiSinh.setBounds(132, 331, 155, 29);
		contentPane.add(textField_MaThiSinh);

		JLabel label_HoVaTen = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		label_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_HoVaTen.setBounds(10, 353, 186, 50);
		contentPane.add(label_HoVaTen);

		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(132, 371, 155, 29);
		contentPane.add(textField_HoVaTen);

		JLabel labelQueQuan_1 = new JLabel("Qu\u00EA qu\u00E1n");
		labelQueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelQueQuan_1.setBounds(10, 391, 111, 50);
		contentPane.add(labelQueQuan_1);

		comboBox_QueQuan = new JComboBox();
		comboBox_QueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan.setBounds(132, 404, 155, 27);
		contentPane.add(comboBox_QueQuan);

		JLabel label_NgaySinh = new JLabel("Ng\u00E0y sinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_NgaySinh.setBounds(10, 430, 186, 50);
		contentPane.add(label_NgaySinh);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(132, 441, 155, 29);
		contentPane.add(textField_NgaySinh);

		JLabel label_GioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh");
		label_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_GioiTinh.setBounds(349, 333, 74, 25);
		contentPane.add(label_GioiTinh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNam.setBounds(453, 331, 83, 29);
		contentPane.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNu.setBounds(543, 332, 83, 29);
		contentPane.add(rdbtnNu);

		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(rdbtnNam);
		btn_gioiTinh.add(rdbtnNu);

		textField_Mon1 = new JTextField();
		textField_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(471, 364, 166, 29);
		contentPane.add(textField_Mon1);

		JLabel label_Mon1 = new JLabel("M\u00F4n 1");
		label_Mon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon1.setBounds(349, 366, 104, 25);
		contentPane.add(label_Mon1);

		textField_Mon2 = new JTextField();
		textField_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(471, 402, 166, 29);
		contentPane.add(textField_Mon2);

		JLabel label_Mon2 = new JLabel("M\u00F4n 2");
		label_Mon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon2.setBounds(349, 404, 104, 25);
		contentPane.add(label_Mon2);

		textField_Mon3 = new JTextField();
		textField_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(471, 441, 166, 29);
		contentPane.add(textField_Mon3);

		JLabel label_Mon3 = new JLabel("M\u00F4n 3");
		label_Mon3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_Mon3.setBounds(349, 443, 104, 25);
		contentPane.add(label_Mon3);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThem.setBounds(20, 501, 83, 29);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);

		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoa.setBounds(155, 501, 83, 29);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(action);

		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCapNhat.setBounds(298, 501, 99, 29);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);

		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLuu.setBounds(453, 501, 83, 29);
		contentPane.add(btnLuu);

		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.addActionListener(action);

		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHuyBo.setBounds(603, 501, 123, 29);
		contentPane.add(btnHuyBo);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHuyTim.setBounds(599, 19, 111, 29);
		contentPane.add(btnHuyTim);

		this.setVisible(true);
	}

	public void xoaForm() {
		textField_MaThiSinh.setText("");
		textField_HoVaTen.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_QueQuan.setSelectedIndex(-1); // setSelectedIndex(-1) được coi là chưa được chọn bất kỳ giá trị nào
		btn_gioiTinh.clearSelection();
	}

	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { ts.getMaThiSinh() + "", ts.getTenThiSinh(), ts.getQueQuan().getTenTinh(),
				ts.getNgaySinh().getDate() + "/" + (1 + ts.getNgaySinh().getMonth()) + "/"
						+ (ts.getNgaySinh().getYear() + 1900),
				(ts.isGioiTinh() ? "Nam" : "Nữ"), ts.getDiemMon1() + "", ts.getDiemMon2() + "",
				ts.getDiemMon3() + "" });
	}

	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(ts)) {
			this.model.insert(ts);
			this.themThiSinhVaoTable(ts);
		} else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (1 + ts.getNgaySinh().getMonth()) + "/"
							+ (ts.getNgaySinh().getYear() + 1900), i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);

				}
			}
		}

	}

	public ThiSinh getThiSinhDaChon() {

		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String tenThiSinh = model_table.getValueAt(i_row, 1) + "";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2) + "");
		String s_ngaySinh = model_table.getValueAt(i_row, 3) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");

		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}

	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDaChon();

		this.textField_MaThiSinh.setText(ts.getMaThiSinh() + "");
		this.textField_HoVaTen.setText((ts.getTenThiSinh() + ""));
		this.comboBox_QueQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (1 + ts.getNgaySinh().getMonth()) + "/"
				+ (ts.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh + "");
		if (ts.isGioiTinh()) {
			rdbtnNam.setSelected(true);
		} else {
			rdbtnNu.setSelected(true);

		}
//		this.btn_gioiTinh.setSelected(null, gioiTinh);
		this.textField_Mon1.setText(ts.getDiemMon1() + "");
		this.textField_Mon2.setText(ts.getDiemMon2() + "");
		this.textField_Mon3.setText(ts.getDiemMon3() + "");

	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa hàng đã chọn!");
		if (luaChon == JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDaChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);

		}

	}

	public void thucHienThemThiSinh() {
//		private int maThiSinh;
//		private String tenThiSinh;
//		private Tinh queQuan;
//		private Date ngaySinh;
//		private float diemMon1, diemMon2, diemMon3;
		int maThiSinh = Integer.valueOf(this.textField_MaThiSinh.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_QueQuan.getSelectedIndex() - 1;
		Tinh tinh = Tinh.getTinhByID(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());
		boolean gioiTinh = true;

		if (this.rdbtnNam.isSelected()) {
			gioiTinh = true;
		} else if (this.rdbtnNu.isSelected()) {
			gioiTinh = false;
		}

		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());

		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		this.themHoacCapNhatThiSinh(ts);
	}

	public void thucHienTim() {
		// Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();

		// Thuc hien tim kiem
//		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex()-1;
//		String maThiSinhTimKiem = this.textField_MaThiSinh_timKiem.getText();
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//		int soLuongDong = model_table.getRowCount();
//		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
//		if (queQuan >= 0) {
//			Tinh tinhDaChon = Tinh.getTinhByID(queQuan);
//			for (int i = 0; i < soLuongDong; i++) {
//				String tenTinh = model_table.getValueAt(i, 2) + "";
//				String id = model_table.getValueAt(i, 0) + "";
//				if (!tenTinh.equals(tinhDaChon)) {                         // sai o day do moi dung o tinh da chon
//					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
//				}
//			}
//		}
//		if (maThiSinhTimKiem.length() > 0) {
//
//			for (int i = 0; i < soLuongDong; i++) {
//				String id = model_table.getValueAt(i, 0) + "";
//				if (!id.equals(maThiSinhTimKiem)) {
//					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
//				}
//			}
//
//		}
//
//		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
//			soLuongDong = model_table.getRowCount();
//			for (int i = 0; i < soLuongDong; i++) {
//				String idTrongTable = model_table.getValueAt(i, 0) + "";
//				if (idTrongTable.equals(idCanXoa.toString())) {
//					
//					try {
//						model_table.removeRow(i);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					break;
//				}
//			}
//		}
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex() - 1;
		String maThiSinhTimKiem = this.textField_MaThiSinh_timKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();

		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhByID(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 2) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		if (maThiSinhTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				System.out.println("idTrongTable: " + idTrongTable);
				if (idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0)
				break;
			else
				model_table.removeRow(0);
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);

		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý thí sinh 1.0!");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn thoát khỏi chương trình không?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	public void thucHienSaveFile() {

		if (this.model.getTenFile().length() > 0) {
			saveFile(this.model.getTenFile());
		} else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}

	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		}

	}

	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while ((ts = (ThiSinh) ois.readObject()) != null) {
				ds.add(ts);

			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		this.model.setDsThiSinh(ds);

	}
}
