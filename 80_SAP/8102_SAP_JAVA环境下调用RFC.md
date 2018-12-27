## SAP JAVA环境下RFC调用示例
2018.12.27  

  能不能用不知道，总之先存起来。 

    import lotus.domino.*;
    import com.sap.mw.jco.*;
    import java.text.SimpleDateFormat;
    import java.util.Date;
    import java.util.Vector;
    import java.io.PrintWriter;
    import java.io.*;

    public class JavaAgent extends AgentBase {

    	private String viewName = "v_key_saplinkbyusename";
    	private String configDbName = "AIS_Org.nsf";
    	private String SAP_Name = null; // 要连接的SAP名称
    	private String SAP_Client = null; // SAP连接客户端名称
    	private String user_Id = null; // 用户名称
    	private String password = null; // 密码
    	private String language = null; // 语言
    	private String sysnr = null; // SAP系统号码
    	private String host_Name = null;
    	private String PrintPath = "";
    	JCO.Client mConnection = null;

    	public Document getDoucumet2(Database CurDb, Session session, AgentContext agentContext) throws Exception {
    		// 读取个人配置中的SAP帐户密码的DOC
    		Database Configdb = null;
    		Database SysDb = null;
    		Document SapConfigDoc = null;
    		Document Sysdoc = null;
    		View ConView = null;
    		View DepView = null;
    		View ComView = null;
    		View SysView = null;
    		String sysdbname = "AIS_Org.nsf";
    		String depkey = "";
    		String comkey = "";
    		try {
    			String DbPath;
    			String DbPath1;
    			DbPath = CurDb.getFilePath();
    			DbPath = DbPath.substring(0, DbPath.length() - CurDb.getFileName().length());
    			DbPath1 = DbPath + sysdbname;
    			DbPath = DbPath + configDbName;

    			// 读取组织库
    			SysDb = session.getDatabase(CurDb.getServer(), DbPath1, true);
    			// 读取个人配置试图
    			SysView = SysDb.getView("v_or_deptbyperson_new");
    			// 读取个人配置文档
    			Sysdoc = SysView.getDocumentByKey(agentContext.getEffectiveUserName().toUpperCase(), true);

    			return Sysdoc;
    		} catch (Exception e) {
    			e.printStackTrace();
    			return null;
    		}
    	}

    	public Document getDoucumet1(Database CurDb, Session session, AgentContext agentContext) throws Exception {

    		Database Configdb = null;
    		Database SysDb = null;
    		Document SapConfigDoc = null;
    		Document Sysdoc = null;
    		View ConView = null;
    		View DepView = null;
    		View ComView = null;
    		View SysView = null;
    		String sysdbname = "AIS_Org.nsf";
    		String depkey = "";
    		String comkey = "";
    		try {
    			String DbPath;
    			String DbPath1;
    			DbPath = CurDb.getFilePath();
    			DbPath = DbPath.substring(0, DbPath.length() - CurDb.getFileName().length());
    			DbPath1 = DbPath + sysdbname;
    			DbPath = DbPath + configDbName;

    			// 读取组织库
    			SysDb = session.getDatabase(CurDb.getServer(), DbPath1, true);
    			// 读取个人配置试图
    			SysView = SysDb.getView("v_or_deptbyperson_new");
    			// 读取个人配置文档
    			Sysdoc = SysView.getDocumentByKey(agentContext.getEffectiveUserName().toUpperCase(), true);
    			depkey = Sysdoc.getItemValueString("ParentCompanyNumber") + "_"
    					+ Sysdoc.getItemValueString("TXTINDEPARTMENT");
    			comkey = Sysdoc.getItemValueString("ParentCompanyNumber");
    			// System.out.println(depkey+comkey);
    			// 读取配置数据库
    			Configdb = session.getDatabase(CurDb.getServer(), DbPath, true);
    			// 读取视图
    			ConView = Configdb.getView("v_or_saplink_byuser");
    			DepView = Configdb.getView("v_or_saplink_bydep");
    			ComView = Configdb.getView("v_or_saplink_bycom");

    			// 读取配置文档
    			SapConfigDoc = ConView.getDocumentByKey(agentContext.getEffectiveUserName().toUpperCase(), true);
    			if (SapConfigDoc == null) {
    				SapConfigDoc = DepView.getDocumentByKey(depkey, true);
    				if (SapConfigDoc == null) {
    					SapConfigDoc = ComView.getDocumentByKey(comkey, true);
    				}
    			}

    			return SapConfigDoc;
    		} catch (Exception e) {
    			e.printStackTrace();
    			return null;
    		}
    	}

    	public void DelInfo(Database db, String pobh) {
    		try {

    			View view = db.getView("v_key_tx");
    			DocumentCollection dc = view.getAllDocumentsByKey(pobh, true);
    			if (dc.getCount() > 0) {
    				dc.removeAll(true);
    			}
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    		}
    	}

    	// 用关键字返回文档
    	public Document ReturnTypeDoc(Database db, String Key, String vname) throws Exception {

    		Document DateDoc = null;
    		View SearchSubView = null;
    		Vector SearchKey = new Vector();

    		try {
    			SearchSubView = db.getView(vname);
    			SearchSubView.refresh();
    			SearchKey.addElement(Key);

    			DateDoc = SearchSubView.getDocumentByKey(SearchKey, true);

    			if (SearchSubView != null) {
    				SearchSubView.recycle();
    			}
    			SearchKey = null;

    			if (DateDoc != null) {
    				return DateDoc;
    			} else {
    				return null;
    			}

    		} catch (Exception e) {
    			e.printStackTrace();
    			return null;
    		}
    	}

    	public Document getDoucumet(Database CurDb, Vector SapSearchKey, Session session) throws Exception {

    		Database Configdb = null;
    		Document SapConfigDoc = null;
    		View ConView = null;
    		try {
    			String DbPath;
    			DbPath = CurDb.getFilePath();
    			DbPath = DbPath.substring(0, DbPath.length() - CurDb.getFileName().length());
    			DbPath = DbPath + configDbName;

    			// 读取配置数据库
    			Configdb = session.getDatabase(CurDb.getServer(), DbPath, true);
    			// 读取视图
    			ConView = Configdb.getView(viewName);
    			// 读取配置文档
    			SapConfigDoc = ConView.getDocumentByKey(SapSearchKey, false);
    			return SapConfigDoc;
    		} catch (Exception e) {
    			e.printStackTrace();
    			return null;
    		}
    	}

    	// 这个方法将字符串line中的子串oldString全部替换为newString
    	public static final String replace(String line, String oldString, String newString) {
    		if (line == null) {
    			return null;
    		}
    		int i = 0;
    		if ((i = line.indexOf(oldString, i)) >= 0) {
    			char[] line2 = line.toCharArray();
    			char[] newString2 = newString.toCharArray();
    			int oLength = oldString.length();
    			StringBuffer buf = new StringBuffer(line2.length);
    			buf.append(line2, 0, i).append(newString2);
    			i += oLength;
    			int j = i;
    			while ((i = line.indexOf(oldString, i)) > 0) {
    				buf.append(line2, j, i - j).append(newString2);
    				i += oLength;
    				j = i;
    			}
    			buf.append(line2, j, line2.length - j);
    			return buf.toString();
    		}
    		return line;
    	}

    	public void creatlog(Database db, Session session, Document doc, AgentContext agentContext, DateTime writetime,
    			String tcode, String bh, String pzh, String memo, String action) {
    		try { // ---------------------------------------------------------------------
    				/////////////// 在OA中记录开始写SAP的日志start
    			String logDbPath = "oadata/write_sap_log.nsf";
    			Database saplogdb = session.getDatabase(db.getServer(), logDbPath, true);
    			if (saplogdb.isOpen()) {
    			} else {
    				saplogdb.open();
    			}
    			if (saplogdb != null) {

    				// String REQUESTNUMBER = "";

    				// REQUESTNUMBER = doc.getItemValueString("REQUESTNUMBER");

    				Document logdoc = saplogdb.createDocument();
    				logdoc.replaceItemValue("Form", "f_or_saplog");
    				logdoc.replaceItemValue("TCODE", tcode); ///// 记录tcode
    				logdoc.replaceItemValue("DOCUNID", doc.getUniversalID()); // 当前文档UNID
    				logdoc.replaceItemValue("OADbName", db.getFileName()); // 当前库
    				logdoc.replaceItemValue("RequestNum", bh); // 文档REQUESTNUMBER
    				logdoc.replaceItemValue("dealaction", action); // 处理动作
    				logdoc.replaceItemValue("dealuser", doc.getItemValueString("SelfName").trim()); // 记录处理人
    				logdoc.replaceItemValue("dealuserID", doc.getItemValueString("SelfWorkID").trim()); // 记录处理人ID
    				logdoc.replaceItemValue("dealuserCom", doc.getItemValueString("SelfcompanyShortName").trim()); // 处理人所在公司
    				logdoc.replaceItemValue("dealuserDep", doc.getItemValueString("SelfdepartmentShortName").trim()); // 处理人所在部门
    				logdoc.replaceItemValue("dealDate", writetime.getDateOnly()); // 处理日期
    				logdoc.replaceItemValue("dealtime", writetime.getTimeOnly()); // 处理时间
    				logdoc.replaceItemValue("SAPPingZheng", pzh); // sap凭证号
    				logdoc.replaceItemValue("Memo", memo); // 备注
    				logdoc.replaceItemValue("Creater", "*");
    				logdoc.getFirstItem("Creater").setAuthors(true);
    				logdoc.save();

    			}
    			/////////////// 在OA中记录开始写SAP的日志end
    			// ---------------------------------------------------------------------

    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    		}
    	}

    	public void NotesMain() {
    		System.out.println("修改物料主数据(BOM创建录入产品规格)");
    		Session session = null;
    		AgentContext agentContext = null;
    		IRepository repository = null;
    		Document doc = null;
    		Document tempdoc = null;
    		Document tempdoc1 = null;
    		Document tempdochxm = null;
    		JCO.Client client = null;
    		PrintWriter pw;
    		String clientnew = "";

    		String mp = "";
    		String mr = "";
    		mp = "<script>";
    		mp = mp + "var m='';";

    		try {
    			session = getSession();
    			agentContext = session.getAgentContext();

    			doc = agentContext.getDocumentContext();

    			Database db = agentContext.getCurrentDatabase();
    			Database CurDb = agentContext.getCurrentDatabase();
    			Document CurDoc = agentContext.getDocumentContext();

    			Vector SapKey = new Vector();
    			Vector dd = new Vector();
    			SapKey.addElement("dev");

    			String writetime = null;

    			DateTime dt1 = session.createDateTime("Today");
    			dt1.setNow();
    			writetime = dt1.getLocalTime();
    			Document ConfigDoc = getDoucumet(agentContext.getCurrentDatabase(), SapKey, session);
    			// Document ConfigDoc = getDoucumet1(db,session,agentContext);
    			if (ConfigDoc == null) {
    				System.out.println("SAP连接配置文档不存在!");
    			} else {
    				clientnew = ConfigDoc.getItemValueString("Client");
    				this.SAP_Client = ConfigDoc.getItemValueString("Client");
    				this.user_Id = ConfigDoc.getItemValueString("User");
    				this.password = ConfigDoc.getItemValueString("Password");
    				this.language = ConfigDoc.getItemValueString("Language");
    				this.sysnr = ConfigDoc.getItemValueString("SYSTEM");
    				this.host_Name = ConfigDoc.getItemValueString("HostName");
    				// System.out.println("SAP主机：" + this.host_Name);
    				// System.out.println("用户：" + this.user_Id);
    				// System.out.println("密码：" + this.password);
    				/////////////////////////////////////////////////////////////////////

    				/////////////////////////////////////////////////////////////////////////////////

    				DateTime dt = session.createDateTime("Today");
    				dt.setNow();
    				// System.out.println("开始连接" + dt);

    				client = JCO.createClient(this.SAP_Client, // SAP client
    						this.user_Id, // userid
    						this.password, // password
    						this.language, // language
    						this.host_Name, // host name
    						this.sysnr); // system number

    				// Open the connection
    				client.connect();
    				dt.setNow();
    				// System.out.println("连接成功" + dt);
    				repository = JCO.createRepository("MYRepository", client);

    				IFunctionTemplate ftemplate;

    				String alertmsg = "";

    				String FuJia1, FuJia2, FuJia3;

    				View view = db.getView("v_list_CPSubDoc_unid");
    				String unid = null;
    				Vector vc = doc.getItemValue("SelectDocCP");
    				if (vc.size() > 0) {
    					for (int ik = 0; ik < vc.size(); ik++) { // 循环成品
    						unid = vc.elementAt(ik).toString();
    						tempdoc = view.getDocumentByKey(unid, true);
    						if (tempdoc != null) {

    							// **************************************************
    							ftemplate = repository.getFunctionTemplate("ZRFC_MM_MM02");

    							JCO.Function function = new JCO.Function(ftemplate);

    							// 输入结构
    							JCO.Structure IP_ZMM0006 = null;
    							IP_ZMM0006 = function.getImportParameterList().getStructure("IP_ZMM0006");

    							if (IP_ZMM0006 != null) {
    								// IP_ZMM0006.setValue(doc.getItemValueString("WuLiaoType").trim(),"MATL_TYPE");
    								// //物料类型
    								IP_ZMM0006.setValue(tempdoc.getItemValueString("ZuJian").trim(), "MATNR"); // 物料号
    								IP_ZMM0006.setValue("L", "IND_SECTOR"); // 行业领域

    								IP_ZMM0006.setValue("X", "BASIC_VIEW"); // 基本数据视图
    								if (tempdoc.getItemValueString("BaseDanWei").trim().equals("") == false) {
    									IP_ZMM0006.setValue(tempdoc.getItemValueString("BaseDanWei").trim(), "BASE_UOM"); // 基本单位
    								}
    								// IP_ZMM0006.setValue(doc.getItemValueString("JinZhong1").trim(),"NET_WEIGHT");
    								// //净重
    								// IP_ZMM0006.setValue("KG","UNIT_OF_WT"); //重量单位
    								IP_ZMM0006.setValue(doc.getItemValueString("WaiXiang").trim() + "*"
    										+ doc.getItemValueString("WaiXiang_1").trim() + "*"
    										+ doc.getItemValueString("WaiXiang_2").trim() + "/外箱尺寸", "SIZE_DIM"); // 大小量纲

    							}

    							// 输入表(计量单位)
    							JCO.Table IT_UNITSOFMEASURE = null;
    							IT_UNITSOFMEASURE = function.getTableParameterList().getTable("IT_UNITSOFMEASURE");

    							if (doc.getItemValueString("TiJi").trim().equals("") == false) {
    								IT_UNITSOFMEASURE.appendRow();
    								if (tempdoc.getItemValueString("BaseDanWei").trim().equals("") == false) {
    									IT_UNITSOFMEASURE.setValue(tempdoc.getItemValueString("BaseDanWei").trim(),
    											"ALT_UNIT");
    								}
    								IT_UNITSOFMEASURE.setValue("1", "DENOMINATR");
    								IT_UNITSOFMEASURE.setValue("1", "NUMERATOR");
    								// IT_UNITSOFMEASURE.setValue(doc.getItemValueString("MaoZhong").trim(),"GROSS_WT");
    								// //毛重
    								// IT_UNITSOFMEASURE.setValue("KG","UNIT_OF_WT"); //重量单位
    								IT_UNITSOFMEASURE.setValue(doc.getItemValueString("TiJi").trim(), "VOLUME"); // 体积
    								IT_UNITSOFMEASURE.setValue("CD3", "VOLUMEUNIT"); // 体积单位
    								IT_UNITSOFMEASURE.setValue(doc.getItemValueString("WaiXiang").trim(), "LENGTH"); // 长
    								IT_UNITSOFMEASURE.setValue(doc.getItemValueString("WaiXiang_1").trim(), "WIDTH"); // 宽
    								IT_UNITSOFMEASURE.setValue(doc.getItemValueString("WaiXiang_2").trim(), "HEIGHT"); // 高
    								IT_UNITSOFMEASURE.setValue("MM", "UNIT_DIM"); // 单位
    							}

    							FuJia1 = "1";
    							FuJia2 = "CAR";
    							FuJia3 = doc.getItemValueString("XiangZhiShu").trim();

    							if (FuJia1.equals("") == false & FuJia2.equals("") == false & FuJia3.equals("") == false) {
    								IT_UNITSOFMEASURE.appendRow();
    								IT_UNITSOFMEASURE.setValue(FuJia2, "ALT_UNIT"); // 帐面库存单位的可替换计量单位
    								IT_UNITSOFMEASURE.setValue(FuJia1, "DENOMINATR"); // 转换为基本计量单位的分母
    								IT_UNITSOFMEASURE.setValue(FuJia3, "NUMERATOR"); // 基本计量单位转换分子
    							}

    							// 输入结构(OA写入SAP操作历史)
    							JCO.Structure IP_HISTORY = null;
    							IP_HISTORY = function.getImportParameterList().getStructure("IP_HISTORY");

    							if (IP_HISTORY != null) {
    								IP_HISTORY.setValue(doc.getUniversalID(), "OANO"); // OA UNID
    								IP_HISTORY.setValue(doc.getItemValueString("SelfTXTUSERDISPLAYNAME").trim(), "OANAME"); // 操作人姓名
    								IP_HISTORY.setValue(db.getTitle(), "OAMODULE"); // OA模块名
    								IP_HISTORY.setValue(doc.getItemValueString("SelfWorkID").trim(), "OAID"); // OA操作人ID
    								IP_HISTORY.setValue(doc.getItemValueString("SelfcompanyShortName").trim(), "COMPANY"); // 公司
    								IP_HISTORY.setValue(doc.getItemValueString("SelfdepartmentCName").trim(), "DEPT"); // 部门
    								IP_HISTORY.setValue("修改物料主数据(修改产品规格)", "REMARK"); // 备注
    							}

    							// 执行函数
    							client.execute(function);

    							// 返回信息
    							JCO.Table ET_LOG = null;
    							ET_LOG = function.getTableParameterList().getTable("ET_LOG");

    							doc.replaceItemValue("SapReturnInfo", "");

    							Item rtitem;
    							rtitem = doc.getFirstItem("SapReturnInfo");
    							for (int i = 0; i < ET_LOG.getNumRows(); i++) {
    								ET_LOG.setRow(i);
    								rtitem.appendToTextList(ET_LOG.getValue("MESSAGE").toString());
    							}

    							String EP_MATNR = tempdoc.getItemValueString("ZuJian").trim();
    							String EP_SUBRC = function.getExportParameterList().getString("EP_SUBRC"); // 成功失败标志

    							if (EP_SUBRC.equals("0")) { // 成功
    								alertmsg = alertmsg + "物料号：" + tempdoc.getItemValueString("ZuJian").trim() + "写入SAP成功！";
    								mr = mr + "m =m +" + "\"" + "物料号：" + tempdoc.getItemValueString("ZuJian").trim()
    										+ "写入SAP成功！" + "\"" + "+" + "\"" + " \\n" + "\"" + "; ";

    								// 记录OA日志
    								creatlog(db, session, doc, agentContext, dt, "ZRFC_MM_MM02",
    										doc.getItemValueString("REQUESTNUMBER"), EP_MATNR, "", "修改物料主数据(修改产品规格)");
    							} else {
    								alertmsg = alertmsg + "物料号：" + tempdoc.getItemValueString("ZuJian").trim() + "写入SAP失败！"
    										+ replace(rtitem.getText(), "'", "");
    								mr = mr + "m =m +" + "\"" + "物料号：" + tempdoc.getItemValueString("ZuJian").trim()
    										+ "写入SAP失败！" + replace(rtitem.getText(), "'", "") + "\"" + "+" + "\"" + " \\n"
    										+ "\"" + "; ";

    							}

    							// **************************************************

    							tempdoc.recycle();

    						}
    					}
    				}

    				String PrintPath = "";
    				PrintPath = "/oadata/" + db.getFileName() + "/fwrite/" + doc.getUniversalID() + "?EditDocument";
    				pw = getAgentOutput();
    				// pw.println("<script>alert('" + alertmsg + "');window.location='" + PrintPath
    				// + "';</script>" );

    				if (mr.trim().equals("")) {
    					mp = mp + mr + "" + ";window.location='" + PrintPath + "';</script>";
    				} else {
    					mp = mp + mr + "alert(m)" + ";window.location='" + PrintPath + "';</script>";
    				}
    				pw.println(mp);

    			} // end if (ConfigDoc == null){

    		} catch (Exception e) {
    			JCO.releaseClient(client);
    			////////////////////////////////////////////////////////////////////////////////////
    			try {
    				String error = "登陆SAP出错!您的SAP帐户:" + this.user_Id + ".请检查您的SAP帐户名,密码或通知系统管理员!";
    			} catch (Exception e2) {

    			}
    			////////////////////////////////////////////////////////////////////////////////////////
    			e.printStackTrace();
    		} finally {
    			JCO.releaseClient(client);
    			try {
    				if (agentContext != null)
    					agentContext.recycle();
    				if (session != null)
    					session.recycle();
    			} catch (NotesException ne) {
    				ne.printStackTrace();
    			}
    		}

    	}
    }