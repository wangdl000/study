package nablarch.core.repository.component;

import java.util.HashMap;
import java.util.Map;

import nablarch.core.repository.initialization.Initializable;

public class Component2 implements Initializable {

	private String prop1;

	private Map<String, String> initMap = null;

	/**
	 * prop1を取得する。
	 * @return prop1
	 */
	public String getProp1() {
		return prop1;
	}

	/**
	 * prop1をセットする。
	 * @param prop1 セットするprop1。
	 */
	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public Map<String, String> getInitMap() {
		return initMap;
	}

	/**
	 * 初期化処理を行う。
	 */
	public void initialize() {
		initMap = new HashMap<String, String>();
		initMap.put("1", "10");
		initMap.put("2", "20");
		initMap.put("3", "30");
	}
}
