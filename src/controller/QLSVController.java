package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener {
	QLSVView view;

	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: " + actionCommand);

		if (actionCommand.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		} else if (actionCommand.equals("Lưu")) {
			try {
				this.view.thucHienThemThiSinh();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (actionCommand.equals("Cập nhật")) {
			this.view.hienThiThongTinThiSinhDaChon();
		} else if (actionCommand.equals("Xóa")) {
			this.view.thucHienXoa();
		} else if (actionCommand.equals("Hủy bỏ")) {
			this.view.xoaForm();
		} else if (actionCommand.equals("Tìm kiếm")) {
			this.view.thucHienTim();
		} else if (actionCommand.equals("Hủy tìm")) {
			this.view.thucHienTaiLaiDuLieu();
		} else if (actionCommand.equals("About me")) {
			this.view.hienThiAbout();

		}else if (actionCommand.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();

		} else if (actionCommand.equals("Save")) {
			this.view.thucHienSaveFile();

		} else if (actionCommand.equals("Open")) {
			this.view.thucHienOpenFile();

		}

	}

}
