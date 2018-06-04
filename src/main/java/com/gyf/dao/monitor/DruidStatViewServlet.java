package com.gyf.dao.monitor;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.alibaba.druid.support.http.StatViewServlet;

@WebServlet(urlPatterns = "/druid/*", 
initParams={
        @WebInitParam(name="allow",value=""),// IP鐧藉悕鍗� (娌℃湁閰嶇疆鎴栬�呬负绌猴紝鍒欏厑璁告墍鏈夎闂�)
        @WebInitParam(name="deny",value=""),// IP榛戝悕鍗� (瀛樺湪鍏卞悓鏃讹紝deny浼樺厛浜巃llow)
        @WebInitParam(name="loginUsername",value="ryan"),// 鐢ㄦ埛鍚�
        @WebInitParam(name="loginPassword",value="123456"),// 瀵嗙爜
        @WebInitParam(name="resetEnable",value="false")// 绂佺敤HTML椤甸潰涓婄殑鈥淩eset All鈥濆姛鑳�
})
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = 1L;

}
