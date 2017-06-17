package com.gys.sm.item.tag.d;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import com.gys.sm.item.cache.DictionaryCache;


public class DictTag extends BodyTagSupport {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dictCode;
    private String dictValue;
    
    public String getDictCode() {
		return dictCode;
	}
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	public String getDictValue() {
		return dictValue;
	}
	public void setDictValue(String dictValue) {
		this.dictValue = dictValue;
	}



	@Override
    public int doStartTag() throws JspException {
        StringBuffer sb = new StringBuffer();
        try {
            sb.append(DictionaryCache.getName(dictCode, dictValue));
            this.pageContext.getOut().write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
			e.printStackTrace();
		}
        return SKIP_BODY;
    }


}
