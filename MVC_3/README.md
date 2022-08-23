# InternWork

chương trình có 1 màn hình hiển thị chuyển động và 1 màn hình hiển thị nút bấm

Chia chương trình thành 3 phần:

	Model:
		class Ball:	
				Hiển trị trên màn hình
				Tọa độ x, y
				Tốc độ di chuyển xa, ya
				Bán kính DIAMETER
				Các method: 
					set get các phần tử
					move: di chuyển trên màn hình, khi gặp các cạnh sẽ bật ngược lại.
					paint: vẽ hình tròn màu đen
					set, get tọa độ hiện tại
					
	Control:
		class MyMouseListener: 
					kế thừa từ inteface MouseListener
					output là tọa độ bấm trên BoardDisplay

					method pressed:tọa độ (x,y) được kiểm tra xem có trùng với các hình chữ nhật
		class MyKeyListener: 
					kế thừa từ inteface KeyListener
 	View:
		class View: 
				kế thừ từ class JFrame 
				chứa 2 class Screen và class BoardDisplay và class Ball
		class Screen: 
				kế thừa JPanel
				màn hình Hiển thị Ball
				gồm chiều dài chiều rộng Width và Height
				class View để lâý dữ liệu 
				các method: 
					move: ball.move
					loop: move(); repaint();
					set vị trí ball
		class BoardDisplay: 
				kết thừa JPanel
				màn hình hiển thị 3 hình chữ nhật: hình chữ nhật màu đỏ set tọa độ ball về (0,0)
				hình chữ nhật xanh lam set tọa độ ball về góc cuối của màn hình Screen
				hình chữ nhật xanh lá thoát khỏi chương trình
				gồm kích thước Width và Height
				Biến lưu thông tin đã bấm hình chữ nhật xanh lá pressedExitButton
				class View để lấy dữ liệu toàn cục
				class MyMouseListener để lấy input tọa độ con chuột

				các method: 
						exit: kiểm tra xem có thoát chương trình hay không
						loop: gồm method exit();
						set vị trí ball
						get Height và Width của class Screen
						paint: vẽ 3 hình chữ nhật

