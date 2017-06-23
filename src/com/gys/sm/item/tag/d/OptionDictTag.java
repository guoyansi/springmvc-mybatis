package com.gys.sm.item.tag.d;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.gys.sm.item.bean.SysDictionaryBean;
import com.gys.sm.item.cache.DictionaryCache;


public class OptionDictTag extends BodyTagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String dictCode;    
    protected String selected;
    
    public String getDictCode() {
		return dictCode;
	}
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	private String getOption(String dictCode,String selected) throws Exception{
    	List<SysDictionaryBean> list=DictionaryCache.getDictList(dictCode);
    	String str="";
    	for(SysDictionaryBean bean:list){
    		if(selected==null||"".equals(selected)||!bean.getDict_value().equals(selected)){
    			 str+="<option value=\""+bean.getDict_value()+"\">"+bean.getDict_name()+"</option>\n";
    		}else{
    			str+="<option selected=\"selected\" value=\""+bean.getDict_value()+"\">"+bean.getDict_name()+"</option>\n";
    		}
       	}
    	return str;
    }
    
    @Override
    public int doStartTag() throws JspException {
    	StringBuffer sb = new StringBuffer();    	
    	try {
    		sb.append(getOption(dictCode,selected));
			this.pageContext.getOut().write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
    	return SKIP_BODY;
    }
}
