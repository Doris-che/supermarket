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
 * @开发者 车玉红
 * @类别   控制台的操作类接口的实现
 * @开始日期 2020-12-07
 * @结束日期 2020-12-17
 * @版本V1.0
 * @说明用于封装的操作信息--功能的实现
 */

public class OperatorImpl implements Operator {
	private User user = null;
	@Override
	/*
	 * 系统的启动方法
	 */
	public void start() {
		showmainMenu();
	}
	
	/*
	 * 显示系统主界面
	 */

	private void showmainMenu() {

		System.out.println("**************欢迎使用  超市管理系统  **************");
		System.out.println("1登录");
		System.out.println("2退出系统");
		System.out.println("**************   请选择数字1/2 **************");

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
				System.out.println("谢谢使用！");
				System.exit(0);
				break;

			default:
				flag = true;
				System.out.println("请输入数字1或2！");
				break;
			}
		} while (flag);

	}
    
	/*
           * 显示登录界面
     */
	private void loginMenu() {
		UserService userService = new UserServicelmpl();

		boolean flag = true;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名！");
			String username = scanner.next();
			System.out.println("请输入密码！");
			String userpwd = scanner.next();

		    user = userService.loginByUsernameAndUserpwd(username, userpwd);
			if (user == null) {
				flag = true;
				System.out.println("登录失败");
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

	    // 收银
	    private void shouyin() {
		System.out.println("**********  收银界面    **********");
		System.out.println("请选择1 扫描商品 2修改数量 3结账 4退出");
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
				System.out.println("请输入数字1-4！");
				break;
			}
		} while (flag);


	}
       
	   //扫描商品
	   private void scanProduct() {
		String product_no=null;
		boolean flag=true;
		System.out.println("请输入商品编号");
		Scanner scanner = new Scanner(System.in);
		product_no=scanner.next();
		ProductService productService=new ProductServicelmpl();
		CartService cartService=new CartServiceImpl();
		int rows = productService.countByProduct_no(product_no);
		if(rows==0) {
			System.out.println("对不起,没有此商品,扫描失败!!!");
		} else {
			rows=cartService.addCatrByProduct_no(product_no);
			if (rows==1) {
				System.out.println("扫描成功");
			} else {
				System.out.println("扫描失败");
			}
		
		Cart cart =cartService.queryCatrByProduct_no(product_no);
		
		if (cart!=null) {
			System.out.println("商品名称                                       数量                                                单价                                  金额");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("("+cart.getProduct_no()+")"+cart.getProduct_name()+cart.getProduct_unit()+"               "+cart.getCart_num()+"           "+cart.getProduct_price()+"             "+(cart.getCart_num()*cart.getProduct_price()));
			System.out.println("-----------------------------------------------------------------------------");
		}			
	}
		shouyin();
	}
	  
	   //修改商品数量
	   private void modified() {
		Scanner scanner=null;
		CartService cartService=new CartServiceImpl();
		boolean flag=true;
		String product_no=null;
		do {
			scanner=new Scanner(System.in);
			System.out.println("输入要修改的商品编号:");
			product_no=scanner.next();
			int count=cartService.countCartByProduct_no(product_no);
			if(count==1) {
				break;
			}	
			System.out.println("没有扫描此商品");
		} while (true);
		
		int cart_num=0;
		do {
			try {
				scanner=new Scanner(System.in);
				System.out.println("输入要修改的数量:");
				cart_num=scanner.nextInt();
				if(cart_num>0) {
					break;
				}
				System.out.println("修改的数量必须大于0");
			} catch (Exception e) {
				System.out.println("请输入正确的数字");
			}	
		} while (true);
		int rows=cartService.updateCart(product_no,cart_num);
		if (rows==1) {
			System.out.println("修改成功");
			Cart cart=cartService.queryCatrByProduct_no(product_no);
			if(cart!=null) {
				System.out.println("商品名称                                                  数量                         单价                      金额");
				System.out.println("-------------------------------------------------------------------------");
					System.out.println("("+cart.getProduct_no()+")"+cart.getProduct_name()+cart.getProduct_unit()+"               "+cart.getCart_num()+"           "+cart.getProduct_price()+"             "+(cart.getCart_num()*cart.getProduct_price()));
				System.out.println("-------------------------------------------------------------------------");
			}
		} else {
			System.out.println("修改失败");
		}
		shouyin();
	}

	   //结账
	   private void checkOut() {
		double totalMoney=0;
		CartService cartService=new CartServiceImpl();
		totalMoney=cartService.fetchTotalMoney();
		if (totalMoney!=0) {
			System.out.println("总金额:"+totalMoney);
			System.out.println("1 普通结账 2 会员结账");
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
			System.out.println("没有扫描商品,请扫描!!!");
		}
		shouyin();
	}

	         //会员结账
	          private void memberCheckout(double totalMoney) {
		MemberService memberService = new MemberServiceImpl();
		// 1 接收会员卡号
		Member member =null;
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入会员卡号:");
			String member_no = scanner.next();
			member = memberService.countMemberByMember_no(member_no);
			if (member!=null) {
				break;
			}
			System.out.println("会员不存在:");
		} while (true);
		// 2 获取付款金额
		double money = 0;
		do {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("请输入您要支付的金额:");
				money = scanner.nextDouble();
				if (money < 0) {
					System.out.println("付款金额必须大于0");
					continue;
				}
				if (money < totalMoney) {
					System.out.println("付款金额必须不小于总金额");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("请输入正确的金额格式!!!");
			}
		} while (true);
		// 3 输出小票
		System.out.println("\t\t\t超市");
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = dateFormat.format(date);
		int num = new Random().nextInt(100);
		System.out.println("收银员号:" + user.getUser_no() + "      小票号:" + dateString + num);
		CartService cartService = new CartServiceImpl();
		List<Cart> cartList = cartService.queryAllCart();
		System.out.println("序号          商品名称            数量           单价             金额");
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
		System.out.println("总数量:" + sum_cart_num + "      应收:" + totalMoney);
		System.out.println("实收:" + money + "         找零:" + (money - totalMoney));
		
		int integral=(int)totalMoney;
		int rows=memberService.updateIntegral(member.getMember_no(),integral);
		if(rows==1) {
			System.out.println("本次累计积分成功              卡号: "+member.getMember_no());
			System.out.println("消费前积分+本次消费积分=消费后积分");
			System.out.println(member.getIntegral()+"+"+integral+"="+(member.getIntegral()+integral));
		}else {
			System.out.println("本次累计积分失败,请与总服务台联系! ");
		}
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateString = dateFormat.format(date);
		System.out.println(dateString);
		System.out.println("此小票是退换货的凭证,请妥善保存!");
		System.out.println("----------------------------------------------");
		// 4 调整数据
		rows = cartService.updateCartStatus();
		if (rows == cartList.size()) {
			System.out.println("数据更新成功!");
		} else {
			System.out.println("数据更新失败!");
		}

		showmainMenu();

		
	}
	         //普通用户结账
	          private void generalCheckout(double totalMoney) {
		double money=0;
		do {
			try {
				Scanner scanner=new Scanner(System.in);
				System.out.println("请输入您要支付的金额:");
				money=scanner.nextDouble();
				if(money<0) {
					System.out.println("付款金额必须大于0");
					continue;
				}
				if(money<totalMoney) {
					System.out.println("付款金额必须不小于总金额");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("请输入正确的金额格式!!!");
			}
		} while (true);
		
		
		System.out.println("\t\t\t超市");
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString=dateFormat.format(date);
		int num=new Random().nextInt(100);
		System.out.println("收银员号:"+user.getUser_no()+"      小票号:"+dateString+num);
		CartService cartService=new CartServiceImpl();
		List<Cart> cartList=cartService.queryAllCart();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("序号                             商品名称                                 数量                                             单价                                 金额");
		
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
		System.out.println("总数量:"+sum_cart_num+"      应收:"+totalMoney);
		System.out.println("实收:"+money+"         找零:"+(money-totalMoney));
		dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		dateString=dateFormat.format(date);
		System.out.println(dateString);
		System.out.println("此小票是退换货的凭证,请妥善保存!");
		System.out.println("-------------------------------------------------------------------------------");
		
		int rows=cartService.updateCartStatus();
		if(rows==cartList.size()) {
			System.out.println("数据更新成功!");
		}
		
		
	}

	// 库存
	private void kuCun() {
		System.out.println("**********    库存管理界面    **********");
		System.out.println("请选择相应的操作 1商品入库 2商品出库 3新增商品 4查询所有商品 5查询单个商品 6返回");

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
				System.out.println("请输入1-6的数字！！！");
				break;
			}
		} while (flag);

	}

	     //入库
	     private void shangPinRuKu() {
		Scanner scanner = new Scanner(System.in);
		ProductService productService = new ProductServicelmpl();
		String product_no = null;
		int product_num = 0;
		boolean flag = true;
		do {
			System.out.println("请输入入库商品编号");

			scanner = new Scanner(System.in);
			product_no = scanner.next();
			int rows = productService.countByProduct_no(product_no);
			if (rows == 1) {
				break;
			}
			System.out.println("该编号的商品不存在，请选择3：新增商品");
			kuCun();
		} while (flag);
		do {
			try {
				flag = false;
				System.out.println("请输入入库数量");
				product_num = scanner.nextInt();
				if (product_num > 0) {
					break;
				}
				flag = false;
				System.out.println("新增数量必须大于0");
			} catch (Exception e) {
				flag = false;
				System.out.println("数值格式错误");
			}
		} while (flag);

		int rows = productService.ruKuChaChong(product_no, product_num);
		if (rows == 1) {
			System.out.println("入库成功");
			chaXunSuoYouShangPin();

		} else {
			System.out.println("入库失败");
		}
		kuCun();
	}
	     //出库
	     private void shangPinChuKu() {
		ProductService productService = new ProductServicelmpl();
		Scanner scanner = null;
		String product_no = null;
		boolean flag = true;
		int product_num = 0;
		do {
			System.out.println("请输入选择出库的商品号");
			scanner = new Scanner(System.in);
			product_no = scanner.next();
			int rows = productService.countByProduct_no(product_no);
			if (rows == 1) {
				break;  }
			System.out.println("该编号的商品不存在");
		} while (flag);
		do {
			scanner = new Scanner(System.in);
			try {
				flag = false;
				System.out.println("请输入商品的数量");
				product_num = scanner.nextInt();
				if (product_num > 0) {
					break;  }
				flag = false;
				System.out.println("数量必须大于0");
			} catch (Exception e) {
				System.out.println("数量格式错误");     }
		} while (flag);
		Product product = productService.queryByProductno(product_no);
		if (product != null && product.getProduct_num() >= product_num) {
			int rows = productService.chuKuByProduct_no(product_no, product_num);
			if (rows == 1) {
				System.out.println("出库成功");
			} else {
				System.out.println("出库失败");
			}
			chaXunSuoYouShangPin();
		} else {
			System.out.println("库存不足");
			System.out.println(
					product.getProduct_no() + "\t\t" + product.getProduct_name() + "\t\t" + product.getProduct_price()
							+ "\t\t" + product.getProduct_unit() + "\t\t" + product.getProduct_num());
			kuCun();
		}
	}
         // 新增商品
	     private void xinZengShangPin() {
		Scanner scanner = new Scanner(System.in);
		String product_no = null;
		boolean flag = true;
		do {
			System.out.println("请输入新增商品编号");
			ProductService productService = new ProductServicelmpl();
			scanner = new Scanner(System.in);
			product_no = scanner.next();
			int rows = productService.countByProduct_no(product_no);
			if (rows == 0) {
				break;
			}
			System.out.println("该编号的商品已存在");
			xinZengShangPin();
		} while (flag);
		scanner = new Scanner(System.in);
		System.out.println("请输入商品名");
		String product_name = scanner.next();

		System.out.println("请输入商品价格");
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
				System.out.println("价格必须大于0");
			} catch (Exception e) {
				flag = false;
				e.printStackTrace();
				System.out.println("价格格式错误");
			}

		} while (flag);
		scanner = new Scanner(System.in);
		System.out.println("请输入商品单位");
		String product_unit = scanner.next();
		System.out.println("请输入商品数量");
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
				System.out.println("数量必须大于0");
			} catch (Exception e) {
				System.out.println("数量格式错误");
			}

		} while (flag);

		System.out.println(
				product_no + "   " + product_name + "  " + product_price + "   " + product_unit + "  " + product_num);
//封装
		Product product = new Product();
		product.setProduct_name(product_name);
		product.setProduct_no(product_no);
		product.setProduct_price(product_price);
		product.setProduct_unit(product_unit);
		product.setProduct_num(product_num);

		ProductService productService = new ProductServicelmpl();
		int rows = productService.addProduct(product);
		if (rows == 1) {
			System.out.println("新增商品成功");
		} else {
			System.out.println("新增商品失败");
		}
		chaXunSuoYouShangPin();
		kuCun();
	}
         // 查询所有商品
	     private void chaXunSuoYouShangPin() {
		ProductService productService = new ProductServicelmpl();
		List<Product> productList = productService.fetchALLProductList();
		System.out.println("商品编号\t\t商品名称\t\t商品单价\t\t商品单位\t\t商品数量");
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
	     //查询单个商品
	     private void chaXunDanGeShangPin() {
		ProductService productService = new ProductServicelmpl();
		System.out.println("输入编号");
		Scanner scanner = new Scanner(System.in);
		String product_no = scanner.next();
		Product product = productService.queryByProductno(product_no);
		if (product_no == null) {
			System.out.println("对不起，没有该商品");
		} else {
			System.out.println("商品编号\t\t商品名称\t\t商品单价\t\t商品单位\t\t商品数量");
			System.out.println(
					product.getProduct_no() + "\t\t" + product.getProduct_name() + "\t\t" + product.getProduct_price()+ "\t\t" + product.getProduct_unit() + "\t\t" + product.getProduct_num());

		}
		kuCun();
	}

}