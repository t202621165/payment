package ${package}.${moduleName}.impl;

import java.io.Serializable;

/**
 * ${tableName}
 * @author ${author}
 * @date ${date?string('yyyy年MM月dd日 HH:mm:ss')}
 */
public class ${className} implements Serializable {
	private static final long serialVersionUID = 1L;

    <#if columns?exists>
        <#list columns as column>
    private String ${column};
    
        </#list>
   <#if alias?exists && alias?size gt 0>
	public void initPreProcess() {
		<#assign keys=alias?keys/>
		<#list keys as key>
		alias.put("${key}", "${alias["${key}"]}");
		</#list>
	}
	
	</#if>
	public void test() {
	
	}
	
        <#list columns as column>
    public String get${column?cap_first}() {
        return this.${column};
    }

    public ${className} set${column}(String ${column}) {
        this.${column} = ${column};
        return this;
    }
        </#list>
    </#if>
}
