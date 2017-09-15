package com.lzw.common.resource.dto;

public class CommonTranslator {

    public static CommonResp translateToCommonResponse() {
        CommonResp commonResp = new CommonResp();
        commonResp.setCode("200");
        commonResp.setDesc("success");
        return commonResp;
    }

    public static CommonResp translateToCommonResponse(String code, String desc, Object data) {
        CommonResp commonResp = new CommonResp();
        commonResp.setCode(code);
        commonResp.setDesc(desc);
        commonResp.setData(data);
        return commonResp;
    }

}
