package com.ly.show.controller;

import com.ly.show.model.*;
import com.ly.show.service.BrowseService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/browse")
@CrossOrigin(origins = "*", maxAge=3600)
public class BrowseController {

    @Autowired
    private BrowseService browseService;

    /**
     * 树形接口数据查询接口
     * @param requestData
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseData<List<SearchResultData>> processSearchByType(@RequestBody RequestData<QSearchByTypeRec> requestData){
        ResponseData<List<SearchResultData>> responseData = new ResponseData<>();

        QSearchByTypeRec data = requestData.getData();
        if(data == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return  responseData;
        }

        return browseService.processSearchByType(data);
    }


    @RequestMapping(value = "/listDetail", method = RequestMethod.POST)
    public ResponseData<List<QListDetailRst>> processListDetail(@RequestBody RequestData<QAssociationDetailRec> requestData) {
        ResponseData<List<QListDetailRst>> responseData = new ResponseData<>();

        QAssociationDetailRec data = requestData.getData();
        if(data == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return  responseData;
        }

        return browseService.processListDetail(data);
    }

    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public ResponseData<QDetailRst> processDetail(@RequestBody RequestData<QDetailRec> requestData) {
        ResponseData<QDetailRst> responseData = new ResponseData<>();

        QDetailRec data = requestData.getData();
        if(data == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return  responseData;
        }

        return browseService.processDetail(data);
    }

    @RequestMapping(value = "/search", method =  RequestMethod.POST)
    public ResponseData<List<QListDetailRst>> processSearch(@RequestBody RequestData<QSearchRec> requestData){
        ResponseData<List<QListDetailRst>> responseData = new ResponseData<>();

        QSearchRec data = requestData.getData();
        if(data == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return  responseData;
        }

        return browseService.processSearch(data);
    }

    @RequestMapping(value = "/tree", method =  RequestMethod.POST)
    public ResponseData<QTreeRst> processTree(@RequestBody RequestData<?> requestData){
        return browseService.processTree();
    }

    @RequestMapping(value = "/searchGu", method =  RequestMethod.POST)
    public ResponseData<List<QSearchLikeRst>> processSearchGu(@RequestBody RequestData<QSearchLikeRec> requestData){
        ResponseData<List<QSearchLikeRst>> responseData = new ResponseData<>();

        QSearchLikeRec data = requestData.getData();
        if(data == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return  responseData;
        }

        return browseService.processSearchGu(data);
    }

    @RequestMapping(value = "/searchMe", method =  RequestMethod.POST)
    public ResponseData<List<QSearchLikeRst>> processSearchMe(@RequestBody RequestData<QSearchLikeRec> requestData){
        ResponseData<List<QSearchLikeRst>> responseData = new ResponseData<>();

        QSearchLikeRec data = requestData.getData();
        if(data == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return  responseData;
        }

        return browseService.processSearchMe(data);
    }

    @RequestMapping(value = "/searchGe", method =  RequestMethod.POST)
    public ResponseData<List<QSearchLikeRst>> processSearchGe(@RequestBody RequestData<QSearchLikeRec> requestData){
        ResponseData<List<QSearchLikeRst>> responseData = new ResponseData<>();

        QSearchLikeRec data = requestData.getData();
        if(data == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return  responseData;
        }

        return browseService.processSearchGe(data);
    }

    @RequestMapping("/Excel")
    public Object excelFind(@RequestParam(name = "locate", required = true) Integer locate,
                            @RequestParam(name = "type", required = true) Integer type,
                            @RequestParam(name = "key", required = false) String key,
                            @RequestParam(name = "value", required = false) String value,
                            @RequestParam(name = "gutMicrobiota", required = false) String gutMicrobiota,
                            @RequestParam(name = "metabolite", required = false) String metabolite,
                            @RequestParam(name = "gene", required = false) String gene,
                            HttpServletResponse response) {
        XSSFWorkbook wb = new XSSFWorkbook();
        if(locate == 1){
            //browse
            if(type == null || key == null || value == null){
                return null;
            }else{
                wb = browseService.browseDownLoadExcel(type, key, value);
            }
        }else{
            //search
            if(type == null){
                return null;
            }else{
                wb = browseService.searchDownloadExcel(type, gutMicrobiota, metabolite, gene);
            }
        }

        String fileName = "data.xlsx";
        OutputStream outputStream =null;
        try {
            fileName = URLEncoder.encode(fileName,"UTF-8");
            //设置ContentType请求信息格式
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            outputStream = response.getOutputStream();
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/Txt")
    public void queryAccount(@RequestParam(name = "locate", required = true) Integer locate,
                             @RequestParam(name = "type", required = true) Integer type,
                             @RequestParam(name = "key", required = false) String key,
                             @RequestParam(name = "value", required = false) String value,
                             @RequestParam(name = "gutMicrobiota", required = false) String gutMicrobiota,
                             @RequestParam(name = "metabolite", required = false) String metabolite,
                             @RequestParam(name = "gene", required = false) String gene,
                             HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if(locate == 1){
            //browse
            if(type == null || key == null || value == null){

            }else{
                browseService.browseDownloadTxt(req, resp, type, key, value);
            }
        }else{
            //search
            if(type == null){

            }else{
                browseService.searchDownloadTxt(req, resp, type, gutMicrobiota, metabolite, gene);
            }
        }
    }

    @RequestMapping("/Csv")
    public String findBuyCSV(@RequestParam(name = "locate", required = true) Integer locate,
                             @RequestParam(name = "type", required = true) Integer type,
                             @RequestParam(name = "key", required = false) String key,
                             @RequestParam(name = "value", required = false) String value,
                             @RequestParam(name = "gutMicrobiota", required = false) String gutMicrobiota,
                             @RequestParam(name = "metabolite", required = false) String metabolite,
                             @RequestParam(name = "gene", required = false) String gene,
                             HttpServletResponse resp) {

        if(locate == 1){
            //browse
            if(type == null || key == null || value == null){
                return null;
            }else{
                return browseService.browseDownloadCsv(resp, type, key, value);
            }
        }else{
            //search
            if(type == null){
                return null;
            }else{
                return browseService.searchDownloadCsv(resp, type, gutMicrobiota, metabolite, gene);
            }
        }
    }


    @RequestMapping(value = "/submit", method =  RequestMethod.POST)
    public ResponseData<CSubmitRst> processSubmit(@RequestBody RequestData<CSubmitRec> requestData) {
        ResponseData<CSubmitRst> responseData = new ResponseData<>();

        CSubmitRec data = requestData.getData();
        if (data == null) {
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        return browseService.processSubmit(data);
    }
}
