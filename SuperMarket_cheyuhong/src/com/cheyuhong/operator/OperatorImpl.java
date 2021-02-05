package com.cheyuhong.operator;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.cheyuhong.bean.Cart;
import com.cheyuhong.bean.Member;
import com.cheyuhong.bean.Product;
import com.cheyuhong.bean.User;
import com.cheyuhong.service.CartService;
import com.cheyuhong.service.CartServiceImpl;
import com.cheyuhong.service.MemberService;
import com.cheyuhong.service.MemberServiceImpl;
import com.cheyuhong.service.ProductService;
import com.cheyuhong.service.ProductServicelmpl;
import com.cheyuhong.service.UserService;
import com.cheyuhong.service.UserServicelmpl;


/*
 * @������ �����
 * @���   ����̨�Ĳ�����ӿڵ�ʵ��
 * @��ʼ���� 2020-12-07
 * @�������� 2020-12-17
 * @�汾V1.0
 * @˵�����ڷ�װ�Ĳ�����Ϣ--���ܵ�ʵ��
 */

public class OperatorImpl implements Operator {
	private User user = null;
	@Override
	/*
	 * ϵͳ����������
	 */
	public void start() {
		showmainMenu();
	}
	
	/*
	 * ��ʾϵͳ������
	 */

	private void showmainMenu() {

		System.out.println("**************��ӭʹ��  ���й���ϵͳ  **************");
		System.out.println("1��¼");
		System.out.println("2�˳�ϵͳ");
		System.out.println("**************   ��ѡ������1/2 **************");

		boolean flag = true;
		do {
			Scanner scanner = new Scanner(System.in);
			String numString = scanner.next();

			switch (numString) {
			case "1":
				loginMenu();
				flag = false;
				break;
			case "2":
				flag = false;
				System.out.println("ллʹ�ã�");
				System.exit(0);
				break;

			default:
				flag = true;
				System.out.println("����������1��2��");
				break;
			}
		} while (flag);

	}
    
	/*
           * ��ʾ��¼����
     */
	private void loginMenu() {
		UserService userService = new UserServicelmpl();

		boolean flag = true;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("�������û�����");
			String username = scanner.next();
			System.out.println("���������룡");
			String userpwd = scanner.next();

		    user = userService.loginByUsernameAndUserpwd(username, userpwd);
			if (user == null) {
				flag = true;
				System.out.println("��¼ʧ��");
			} else {
				flag = false;
				if (user.getUser_type() == 1) {
					kuCun();
				} else {
					shouyin();
				}
			}
		} while (flag);

	}

	    // ����
	    private void shouyin() {
		System.out.println("**********  ��������    **********");
		System.out.println("��ѡ��1 ɨ����Ʒ 2�޸����� 3���� 4�˳�");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		do {
			
			String numString = scanner.next();

			switch (numString) {
			case "1":
				scanProduct();
				flag = false;
				break;
			case "2":
				modified();
				flag = false;
				break;
			case "3":
				checkOut();
				flag = false;
				break;
			case "4":
				showmainMenu();
				flag = false;
				break;
				
			default:
				flag=true;
				System.out.println("����������1-4��");
				break;
			}
		} while (flag);


	}
       
	   //ɨ����Ʒ
	   private void scanProduct() {
		String product_no=null;
		boolean flag=true;
		System.out.println("��������Ʒ���");
		Scanner scanner = new Scanner(System.in);
		product_no=scanner.next();
		ProductService productService=new ProductServicelmpl();
		CartService cartService=new CartServiceImpl();
		int rows = productService.countByProduct_no(product_no);
		if(rows==0) {
			System.out.println("�Բ���,û�д���Ʒ,ɨ��ʧ��!!!");
		} else {
			rows=cartService.addCatrByProduct_no(product_no);
			if (rows==1) {
				System.out.println("ɨ��ɹ�");
			} else {
				System.out.println("ɨ��ʧ��");
			}
		
		Cart cart =cartService.queryCatrByProduct_no(product_no);
		
		if (cart!=null) {
			System.out.println("��Ʒ����                                       ����                                                ����                                  ���");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("("+cart.getProduct_no()+")"+cart.getProduct_name()+cart.getProduct_unit()+"               "+cart.getCart_num()+"           "+cart.getProduct_price()+"             "+(cart.getCart_num()*cart.getProduct_price()));
			System.out.println("-----------------------------------------------------------------------------");
		}			
	}
		shouyin();
	}
	  
	   //�޸���Ʒ����
	   private void modified() {
		Scanner scanner=null;
		CartService cartService=new CartServiceImpl();
		boolean flag=true;
		String product_no=null;
		do {
			scanner=new Scanner(System.in);
			System.out.println("����Ҫ�޸ĵ���Ʒ���:");
			product_no=scanner.next();
			int count=cartService.countCartByProduct_no(product_no);
			if(count==1) {
				break;
			}	
			System.out.println("û��ɨ�����Ʒ");
		} while (true);
		
		int cart_num=0;
		do {
			try {
				scanner=new Scanner(System.in);
				System.out.println("����Ҫ�޸ĵ�����:");
				cart_num=scanner.nextInt();
				if(cart_num>0) {
					break;
				}
				System.out.println("�޸ĵ������������0");
			} catch (Exception e) {
				System.out.println("��������ȷ������");
			}	
		} while (true);
		int rows=cartService.updateCart(product_no,cart_num);
		if (rows==1) {
			System.out.println("�޸ĳɹ�");
			Cart cart=cartService.queryCatrByProduct_no(product_no);
			if(cart!=null) {
				System.out.println("��Ʒ����                                                  ����                         ����                      ���");
				System.out.println("-------------------------------------------------------------------------");
					System.out.println("("+cart.getProduct_no()+")"+cart.getProduct_name()+cart.getProduct_unit()+"               "+cart.getCart_num()+"           "+cart.getProduct_price()+"             "+(cart.getCart_num()*cart.getProduct_price()));
				System.out.println("-------------------------------------------------------------------------");
			}
		} else {
			System.out.println("�޸�ʧ��");
		}
		shouyin();
	}

	   //����
	   private void checkOut() {
		double totalMoney=0;
		CartService cartService=new CartServiceImpl();
		totalMoney=cartService.fetchTotalMoney();
		if (totalMoney!=0) {
			System.out.println("�ܽ��:"+totalMoney);
			System.out.println("1 ��ͨ���� 2 ��Ա����");
			Scanner scanner=new Scanner(System.in);
			String numString=scanner.next();
			switch (numString) {
				case "1": 
					generalCheckout(totalMoney);
					break;
				case "2": 
					memberCheckout(totalMoney);
					break;
				default:
					break;
			}
		}else {
			System.out.println("û��ɨ����Ʒ,��ɨ��!!!");
		}
		shouyin();
	}

	         //��Ա����
	          private void memberCheckout(double totalMoney) {
		MemberService memberService = new MemberServiceImpl();
		// 1 ���ջ�Ա����
		Member member =null;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("�������Ա����:");
			String member_no = scanner.next();
			member = memberService.countMemberByMember_no(member_no);
			if (member!=null) {
				break;
			}
			System.out.println("��Ա������:");
		} while (true);
		// 2 ��ȡ������
		double money = 0;
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("��������Ҫ֧���Ľ��:");
				money = scanner.nextDouble();
				if (money < 0) {
					System.out.println("������������0");
					continue;
				}
				if (money < totalMoney) {
					System.out.println("��������벻С���ܽ��");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("��������ȷ�Ľ���ʽ!!!");
			}
		} while (true);
		// 3 ���СƱ
		System.out.println("\t\t\t����");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = dateFormat.format(date);
		int num = new Random().nextInt(100);
		System.out.println("����Ա��:" + user.getUser_no() + "      СƱ��:" + dateString + num);
		CartService cartService = new CartServiceImpl();
		List<Cart> cartList = cartService.queryAllCart();
		System.out.println("���          ��Ʒ����            ����           ����             ���");
		int i = 1;
		int sum_cart_num = 0;
		for (Cart cart : cartList) {
			if (cart != null) {
				System.out.println("----------------------------------------------");
				System.out.println(i + "          (" + cart.getProduct_no() + ")" + cart.getProduct_name()
						+ cart.getProduct_unit() + "               " + cart.getCart_num() + "           "
						+ cart.getProduct_price() + "             " + (cart.getCart_num() * cart.getProduct_price()));
				System.out.println("----------------------------------------------");
				i++;
				sum_cart_num += cart.getCart_num();
			}
		}
		System.out.println("������:" + sum_cart_num + "      Ӧ��:" + totalMoney);
		System.out.println("ʵ��:" + money + "         ����:" + (money - totalMoney));
		
		int integral=(int)totalMoney;
		int rows=memberService.updateIntegral(member.getMember_no(),integral);
		if(rows==1) {
			System.out.println("�����ۼƻ��ֳɹ�              ����: "+member.getMember_no());
			System.out.println("����ǰ����+�������ѻ���=���Ѻ����");
			System.out.println(member.getIntegral()+"+"+integral+"="+(member.getIntegral()+integral));
		}else {
			System.out.println("�����ۼƻ���ʧ��,�����ܷ���̨��ϵ! ");
		}
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateString = dateFormat.format(date);
		System.out.println(dateString);
		System.out.println("��СƱ���˻�����ƾ֤,�����Ʊ���!");
		System.out.println("----------------------------------------------");
		// 4 ��������
		rows = cartService.updateCartStatus();
		if (rows == cartList.size()) {
			System.out.println("���ݸ��³ɹ�!");
		} else {
			System.out.println("���ݸ���ʧ��!");
		}

		showmainMenu();

		
	}
	         //��ͨ�û�����
	          private void generalCheckout(double totalMoney) {
		double money=0;
		do {
			try {
				Scanner scanner=new Scanner(System.in);
				System.out.println("��������Ҫ֧���Ľ��:");
				money=scanner.nextDouble();
				if(money<0) {
					System.out.println("������������0");
					continue;
				}
				if(money<totalMoney) {
					System.out.println("��������벻С���ܽ��");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("��������ȷ�Ľ���ʽ!!!");
			}
		} while (true);
		
		
		System.out.println("\t\t\t����");
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString=dateFormat.format(date);
		int num=new Random().nextInt(100);
		System.out.println("����Ա��:"+user.getUser_no()+"      СƱ��:"+dateString+num);
		CartService cartService=new CartServiceImpl();
		List<Cart> cartList=cartService.queryAllCart();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("���                             ��Ʒ����                                 ����                                             ����                                 ���");
		
		int i=1;
		int sum_cart_num=0;
		for (Cart cart : cartList) {
			if(cart!=null) {
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(i+"             "+"("+cart.getProduct_no()+")"+cart.getProduct_name()+cart.getProduct_unit()+"               "+cart.getCart_num()+"           "+cart.getProduct_price()+"             "+(cart.getCart_num()*cart.getProduct_price()));
				System.out.println("-----------------------------------------------------------------------");
				i++;
				sum_cart_num+=cart.getCart_num();
			}
		}
		System.out.println("������:"+sum_cart_num+"      Ӧ��:"+totalMoney);
		System.out.println("ʵ��:"+money+"         ����:"+(money-totalMoney));
		dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateString=dateFormat.format(date);
		System.out.println(dateString);
		System.out.println("��СƱ���˻�����ƾ֤,�����Ʊ���!");
		System.out.println("-------------------------------------------------------------------------------");
		
		int rows=cartService.updateCartStatus();
		if(rows==cartList.size()) {
			System.out.println("���ݸ��³ɹ�!");
		}
		
		
	}

	// ���
	private void kuCun() {
		System.out.println("**********    ���������    **********");
		System.out.println("��ѡ����Ӧ�Ĳ��� 1��Ʒ��� 2��Ʒ���� 3������Ʒ 4��ѯ������Ʒ 5��ѯ������Ʒ 6����");

		boolean flag = true;
		do {
			Scanner scanner = new Scanner(System.in);
			String numString = scanner.next();
			switch (numString) {
			case "1":
				flag = false;
				shangPinRuKu();
				break;
			case "2":
				flag = false;
				shangPinChuKu();
				break;
			case "3":
				flag = false;
				xinZengShangPin();
				break;
			case "4":
				flag = false;
				chaXunSuoYouShangPin();
				break;
			case "5":
				flag = false;
				chaXunDanGeShangPin();
				break;
			case "6":
				flag = false;
				showmainMenu();
				break;

			default:
				flag = true;
				System.out.println("������1-6�����֣�����");
				break;
			}
		} while (flag);

	}

	     //���
	     private void shangPinRuKu() {
		Scanner scanner = new Scanner(System.in);
		ProductService productService = new ProductServicelmpl();
		String product_no = null;
		int product_num = 0;
		boolean flag = true;
		do {
			System.out.println("�����������Ʒ���");

			scanner = new Scanner(System.in);
			product_no = scanner.next();
			int rows = productService.countByProduct_no(product_no);
			if (rows == 1) {
				break;
			}
			System.out.println("�ñ�ŵ���Ʒ�����ڣ���ѡ��3��������Ʒ");
			kuCun();
		} while (flag);
		do {
			try {
				flag = false;
				System.out.println("�������������");
				product_num = scanner.nextInt();
				if (product_num > 0) {
					break;
				}
				flag = false;
				System.out.println("���������������0");
			} catch (Exception e) {
				flag = false;
				System.out.println("��ֵ��ʽ����");
			}
		} while (flag);

		int rows = productService.ruKuChaChong(product_no, product_num);
		if (rows == 1) {
			System.out.println("���ɹ�");
			chaXunSuoYouShangPin();

		} else {
			System.out.println("���ʧ��");
		}
		kuCun();
	}
	     //����
	     private void shangPinChuKu() {
		ProductService productService = new ProductServicelmpl();
		Scanner scanner = null;
		String product_no = null;
		boolean flag = true;
		int product_num = 0;
		do {
			System.out.println("������ѡ��������Ʒ��");
			scanner = new Scanner(System.in);
			product_no = scanner.next();
			int rows = productService.countByProduct_no(product_no);
			if (rows == 1) {
				break;  }
			System.out.println("�ñ�ŵ���Ʒ������");
		} while (flag);
		do {
			scanner = new Scanner(System.in);
			try {
				flag = false;
				System.out.println("��������Ʒ������");
				product_num = scanner.nextInt();
				if (product_num > 0) {
					break;  }
				flag = false;
				System.out.println("�����������0");
			} catch (Exception e) {
				System.out.println("������ʽ����");     }
		} while (flag);
		Product product = productService.queryByProductno(product_no);
		if (product != null && product.getProduct_num() >= product_num) {
			int rows = productService.chuKuByProduct_no(product_no, product_num);
			if (rows == 1) {
				System.out.println("����ɹ�");
			} else {
				System.out.println("����ʧ��");
			}
			chaXunSuoYouShangPin();
		} else {
			System.out.println("��治��");
			System.out.println(
					product.getProduct_no() + "\t\t" + product.getProduct_name() + "\t\t" + product.getProduct_price()
							+ "\t\t" + product.getProduct_unit() + "\t\t" + product.getProduct_num());
			kuCun();
		}
	}
         // ������Ʒ
	     private void xinZengShangPin() {
		Scanner scanner = new Scanner(System.in);
		String product_no = null;
		boolean flag = true;
		do {
			System.out.println("������������Ʒ���");
			ProductService productService = new ProductServicelmpl();
			scanner = new Scanner(System.in);
			product_no = scanner.next();
			int rows = productService.countByProduct_no(product_no);
			if (rows == 0) {
				break;
			}
			System.out.println("�ñ�ŵ���Ʒ�Ѵ���");
			xinZengShangPin();
		} while (flag);
		scanner = new Scanner(System.in);
		System.out.println("��������Ʒ��");
		String product_name = scanner.next();

		System.out.println("��������Ʒ�۸�");
		double product_price = 0;
		flag = true;
		do {
			scanner = new Scanner(System.in);

			try {
				product_price = scanner.nextDouble();
				if (product_price > 0) {
					break;
				}
				flag = false;
				System.out.println("�۸�������0");
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				System.out.println("�۸��ʽ����");
			}

		} while (flag);
		scanner = new Scanner(System.in);
		System.out.println("��������Ʒ��λ");
		String product_unit = scanner.next();
		System.out.println("��������Ʒ����");
		int product_num = 0;
		flag = true;
		do {
			scanner = new Scanner(System.in);

			try {
				product_num = scanner.nextInt();
				if (product_num > 0) {
					break;
				}
				flag = false;
				System.out.println("�����������0");
			} catch (Exception e) {
				System.out.println("������ʽ����");
			}

		} while (flag);

		System.out.println(
				product_no + "   " + product_name + "  " + product_price + "   " + product_unit + "  " + product_num);
//��װ
		Product product = new Product();
		product.setProduct_name(product_name);
		product.setProduct_no(product_no);
		product.setProduct_price(product_price);
		product.setProduct_unit(product_unit);
		product.setProduct_num(product_num);

		ProductService productService = new ProductServicelmpl();
		int rows = productService.addProduct(product);
		if (rows == 1) {
			System.out.println("������Ʒ�ɹ�");
		} else {
			System.out.println("������Ʒʧ��");
		}
		chaXunSuoYouShangPin();
		kuCun();
	}
         // ��ѯ������Ʒ
	     private void chaXunSuoYouShangPin() {
		ProductService productService = new ProductServicelmpl();
		List<Product> productList = productService.fetchALLProductList();
		System.out.println("��Ʒ���\t\t��Ʒ����\t\t��Ʒ����\t\t��Ʒ��λ\t\t��Ʒ����");
		if (productList != null && productList.size() > 0) {
			for (int i = 0; i < productList.size(); i++) {
				Product product = productList.get(i);
				System.out.println(product.getProduct_no() + "\t\t" + product.getProduct_name() + "\t\t"
						+ product.getProduct_price() + "\t\t" + product.getProduct_unit() + "\t\t"
						+ product.getProduct_num());

			}
		}
		kuCun();

	}
	     //��ѯ������Ʒ
	     private void chaXunDanGeShangPin() {
		ProductService productService = new ProductServicelmpl();
		System.out.println("������");
		Scanner scanner = new Scanner(System.in);
		String product_no = scanner.next();
		Product product = productService.queryByProductno(product_no);
		if (product_no == null) {
			System.out.println("�Բ���û�и���Ʒ");
		} else {
			System.out.println("��Ʒ���\t\t��Ʒ����\t\t��Ʒ����\t\t��Ʒ��λ\t\t��Ʒ����");
			System.out.println(
					product.getProduct_no() + "\t\t" + product.getProduct_name() + "\t\t" + product.getProduct_price()+ "\t\t" + product.getProduct_unit() + "\t\t" + product.getProduct_num());

		}
		kuCun();
	}

}