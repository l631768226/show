package com.ly.show.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ly.show.dao.AssociationDao;
import com.ly.show.mapper.AssociationMapper;
import com.ly.show.mapper.SubmitinfoMapper;
import com.ly.show.model.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrowseService {

    @Autowired
    private AssociationDao associationDao;

    @Autowired
    private SubmitinfoMapper submitinfoMapper;



    /**
     * 树形接口调用接口
     * @param data
     * @return
     */
    public ResponseData<List<SearchResultData>> processSearchByType(QSearchByTypeRec data){
        ResponseData<List<SearchResultData>> responseData = new ResponseData<>();

        int type = data.getType();
        String key = data.getKey();
        String typeStr = "";
        //根据传入参数判断获取大类型
        if(type == 1){
            //human
            typeStr = "human";
        }else if(type == 2){
            //mouse
            typeStr = "mouse";
        }else{
            //others
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        if(key == null || "".equals(key)){
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        List<SearchResultData> searchList = new ArrayList<>();

        switch (key){
            case "Gut Microbiota":
                searchList = associationDao.findGutMicrobiota(typeStr);
                break;
            case "Metabolite":
                searchList = associationDao.findMetabolite(typeStr);
                break;
            case "Gene":
                searchList = associationDao.findGene(typeStr);
                break;
            default:
                searchList = new ArrayList<>();
                break;
        }

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(searchList);
        return responseData;
    }

    /**
     * 根据id获取详情
     * @param data
     * @return
     */
    public ResponseData<List<QListDetailRst>> processListDetail(QAssociationDetailRec data){
        ResponseData<List<QListDetailRst>> responseData = new ResponseData<>();

        Integer indexId = data.getIndexId();

        if(indexId == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        Integer page = data.getPage();
        Integer pageSize = data.getPageSize();

        int type = data.getType();
        String key = data.getKey();
        String typeStr = "";
        //根据传入参数判断获取大类型
        if(type == 1){
            //human
            typeStr = "human";
        }else if(type == 2){
            //mouse
            typeStr = "mouse";
        }else{
            //others
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        if(key == null || "".equals(key)){
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        String value = data.getValue();
        List<Association> associationList = new ArrayList<>();

        switch (key){
            case "Gut Microbiota":
                if(page == null || pageSize == null){
                    associationList = associationDao.findListGutMicrobiota(typeStr, value);
                }else{
                    PageHelper.startPage(page, pageSize);
                    associationList = associationDao.findListGutMicrobiota(typeStr, value);

                    PageInfo<Association> pageInfo = new PageInfo<>(associationList);
                    responseData.setPaging(pageInfo);
                }
                break;
            case "Metabolite":
                if(page == null || pageSize == null){
                    associationList = associationDao.findListMetabolite(typeStr, value);
                }else{
                    PageHelper.startPage(page, pageSize);
                    associationList = associationDao.findListMetabolite(typeStr, value);

                    PageInfo<Association> pageInfo = new PageInfo<>(associationList);
                    responseData.setPaging(pageInfo);
                }
                break;
            case "Gene":
                if(page == null || pageSize == null){
                    associationList = associationDao.findListGene(typeStr, value);
                }else{
                    PageHelper.startPage(page, pageSize);
                    associationList = associationDao.findListGene(typeStr, value);

                    PageInfo<Association> pageInfo = new PageInfo<>(associationList);
                    responseData.setPaging(pageInfo);
                }
                break;
            default:
                associationList = new ArrayList<>();
                break;
        }


        List<QListDetailRst> qListDetailRstList = new ArrayList<>();

        if(!associationList.isEmpty()){

            for(Association association : associationList){
                QListDetailRst qListDetailRst = new QListDetailRst();
                qListDetailRst.setId(association.getId());
                qListDetailRst.setIndexId(association.getIndex());

                //Human/Mouse
                qListDetailRst.setHumanMouse(association.getHumanMouse());

                //Gut Microbiota(ID)
                String gutmicro = association.getGutmicrobiota();
                String gutIId = association.getGutmicrobiatancbiid();
                String combineStr = combine(gutmicro, gutIId);
                qListDetailRst.setGutMicrobiota(combineStr);

                //Strain
                qListDetailRst.setStrain(association.getStrain());

                //Metabolite
                String metabolite = association.getMetabolite();
                String metabolitePubChemCID = association.getMetabolitepubchemcid();
                String metaboliteHtml = "";
                if(metabolite == null || "".equals(metabolite)){
                    metaboliteHtml = "<p></p>";
                }else if(metabolitePubChemCID == null || "".equals(metabolitePubChemCID)){
                    metaboliteHtml = "<p>"+ metabolite +"</p>";
                }else{
                    metaboliteHtml = "<p>" + metabolite + " (" +"<a target=\"_blank\" href=\"https://pubchem.ncbi.nlm.nih.gov/compound/"
                            + metabolitePubChemCID + "\">"+ metabolitePubChemCID + "</a></span>" + ")" + "</p>";
                }
                qListDetailRst.setMetabolite(metaboliteHtml);

                //Gene
                String gene = association.getGene();
                String geneId = association.getGeneid();
                String geneHtml = "";
                if(gene == null || "".equals(gene)){
                    geneHtml = "<p></p>";
                }else if(geneId == null || "".equals(geneId)){
                    geneHtml = "<p>"+ gene +"</p>";
                }else{
                    geneHtml = "<p>"+ gene + " (" + "<a target=\"_blank\" href=\"https://www.ncbi.nlm.nih.gov/gene/?term="
                            + geneId + "\">"+ geneId + "</a></span>" + ")" + "</p>";
                }
                qListDetailRst.setGene(geneHtml);

                qListDetailRst.setClassification(association.getClassification());
                qListDetailRst.setAlteration(association.getAlteration());
                qListDetailRst.setSequencing(association.getPlatform());

                String pmid = association.getPmid();
                if(pmid == null || "".equals(pmid)){
                    pmid = "<p></p>";
                }else{
                    pmid = "<p><a target=\"_blank\" href=\"http://ncbi.nlm.nih.gov/pubmed/" + pmid + "\">"+ pmid + "</a></span></p>";
                }
                qListDetailRst.setPmid(pmid);
                qListDetailRstList.add(qListDetailRst);
            }
        }

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qListDetailRstList);
        return responseData;
    }


    public ResponseData<QDetailRst> processDetail(QDetailRec data) {
        ResponseData<QDetailRst> responseData = new ResponseData<>();

        Integer index = data.getIndexId();
        Integer id = data.getId();
        if(index == null || id == null){
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        Literature literature = associationDao.findLiterByIndex(index);
        Association association = associationDao.findByIndexAndId(index, id);

        FirstDetail firstDetail = new FirstDetail();
        SecondDetail secondDetail = new SecondDetail();

        BeanUtils.copyProperties(literature, firstDetail);
        BeanUtils.copyProperties(association, secondDetail);
        //PMID
        String pmid = literature.getPmid();
        if(pmid == null || "".equals(pmid)){
            pmid = "<p></p>";
        }else{
            pmid = "<p><a target=\"_blank\" href=\"http://ncbi.nlm.nih.gov/pubmed/" + pmid + "\">"+ pmid + "</a></span></p>";
        }
        firstDetail.setPmid(pmid);

        //Gut Microbiata NCBI ID
        String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
        if(gutmicrobiatancbiid == null || "".equals(gutmicrobiatancbiid)){
            gutmicrobiatancbiid = "<p></p>";
        }else{
            gutmicrobiatancbiid = "<p><a target=\"_blank\" href=\"https://www.ncbi.nlm.nih.gov/Taxonomy/Browser/wwwtax.cgi?id="
                    + gutmicrobiatancbiid + "\">"+ gutmicrobiatancbiid + "</a></span></p>";
        }
        secondDetail.setGutmicrobiatancbiid(gutmicrobiatancbiid);

        //Substrate PubChem CID
        String substratepubchemcid = association.getSubstratepubchemcid();
        if(substratepubchemcid == null || "".equals(substratepubchemcid)){
            substratepubchemcid = "<p></p>";
        }else{
            substratepubchemcid = "<p><a target=\"_blank\" href=\"https://pubchem.ncbi.nlm.nih.gov/compound/"
                    + substratepubchemcid + "\">"+ substratepubchemcid + "</a></span></p>";
        }
        secondDetail.setSubstratepubchemcid(substratepubchemcid);

        //Metabolite PubChem CID
        String metabolitePubChemCID = association.getMetabolitepubchemcid();
        if(metabolitePubChemCID == null || "".equals(metabolitePubChemCID)){
            metabolitePubChemCID = "<p></p>";
        }else{
            metabolitePubChemCID = "<p><a target=\"_blank\" href=\"https://pubchem.ncbi.nlm.nih.gov/compound/"
                    + metabolitePubChemCID + "\">"+ metabolitePubChemCID + "</a></span></p>";
        }
        secondDetail.setMetabolitepubchemcid(metabolitePubChemCID);

        //Gene ID
        String geneId = association.getGeneid();
        if(geneId == null || "".equals(geneId)){
            geneId = "<p></p>";
        }else{
            geneId = "<p><a target=\"_blank\" href=\"https://www.ncbi.nlm.nih.gov/gene/?term="
                    + geneId + "\">"+ geneId + "</a></span></p>";
        }
        secondDetail.setGeneid(geneId);

        QDetailRst qDetailRst = new QDetailRst();
        qDetailRst.setFirst(firstDetail);
        qDetailRst.setSecond(secondDetail);

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qDetailRst);
        return  responseData;
    }


    public ResponseData<List<QListDetailRst>> processSearch(QSearchRec data) {
        ResponseData<List<QListDetailRst>> responseData = new ResponseData<>();

        Integer type = data.getType();
        String gutMicrobiotaSub = data.getGutMicrobiota();
        String metaboliteSub = data.getMetabolite();
        String geneSub = data.getGene();

        if(type == null && (gutMicrobiotaSub == null || "".equals(gutMicrobiotaSub)) &&
                (metaboliteSub == null || "".equals(metaboliteSub)) && (geneSub == null || "".equals(geneSub))){
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        String typeStr = "";
        //根据传入参数判断获取大类型
        if(type == 1){
            //human
            typeStr = "human";
        }else if(type == 2){
            //mouse
            typeStr = "mouse";
        }else{
            //others
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        Integer page = data.getPage();
        Integer pageSize = data.getPageSize();
        List<Association> associationList = new ArrayList<>();
        if(page == null || pageSize == null) {
            associationList = associationDao
                    .searchAssociation(typeStr, gutMicrobiotaSub, metaboliteSub, geneSub);
        }else{
            PageHelper.startPage(page, pageSize);
            associationList = associationDao
                    .searchAssociation(typeStr, gutMicrobiotaSub, metaboliteSub, geneSub);
            PageInfo<Association> pageInfo = new PageInfo<>(associationList);
            responseData.setPaging(pageInfo);
        }
        List<QListDetailRst> qListDetailRstList = new ArrayList<>();
        if(!associationList.isEmpty()) {
            for (Association association : associationList) {
                QListDetailRst qListDetailRst = new QListDetailRst();
                qListDetailRst.setId(association.getId());
                qListDetailRst.setIndexId(association.getIndex());

                //Human/Mouse
                qListDetailRst.setHumanMouse(association.getHumanMouse());

                //Gut Microbiota(ID)
                String gutmicro = association.getGutmicrobiota();
                String gutIId = association.getGutmicrobiatancbiid();
                String combineStr = combine(gutmicro, gutIId);
                qListDetailRst.setGutMicrobiota(combineStr);

                //Strain
                qListDetailRst.setStrain(association.getStrain());

                //Metabolite
                String metabolite = association.getMetabolite();
                String metabolitePubChemCID = association.getMetabolitepubchemcid();
                String metaboliteHtml = "";
                if (metabolite == null || "".equals(metabolite)) {
                    metaboliteHtml = "<p></p>";
                } else if (metabolitePubChemCID == null || "".equals(metabolitePubChemCID)) {
                    metaboliteHtml = "<p>" + metabolite + "</p>";
                } else {
                    metaboliteHtml = "<p>" + metabolite + " (" +"<a target=\"_blank\" href=\"https://pubchem.ncbi.nlm.nih.gov/compound/"
                            + metabolitePubChemCID + "\">"+ metabolitePubChemCID + "</a></span>" + ")" + "</p>";
                }
                qListDetailRst.setMetabolite(metaboliteHtml);

                //Gene
                String gene = association.getGene();
                String geneId = association.getGeneid();
                String geneHtml = "";
                if (gene == null || "".equals(gene)) {
                    geneHtml = "<p></p>";
                } else if (geneId == null || "".equals(geneId)) {
                    geneHtml = "<p>" + gene + "</p>";
                } else {
                    geneHtml = "<p>"+ gene + " (" + "<a target=\"_blank\" href=\"https://www.ncbi.nlm.nih.gov/gene/?term="
                            + geneId + "\">"+ geneId + "</a></span>" + ")" + "</p>";
                }
                qListDetailRst.setGene(geneHtml);

                qListDetailRst.setClassification(association.getClassification());
                qListDetailRst.setAlteration(association.getAlteration());
                qListDetailRst.setSequencing(association.getPlatform());

                String pmid = association.getPmid();
                if (pmid == null || "".equals(pmid)) {
                    pmid = "<p></p>";
                } else {
                    pmid = "<p><a target=\"_blank\" href=\"http://ncbi.nlm.nih.gov/pubmed/" + pmid + "\">" + pmid + "</a></span></p>";
                }

                qListDetailRst.setPmid(pmid);
                qListDetailRstList.add(qListDetailRst);
            }
        }


        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qListDetailRstList);
        return  responseData;
    }

    public ResponseData<QTreeRst> processTree() {

        ResponseData<QTreeRst> responseData = new ResponseData<>();

        QTreeRst qTreeRst = new QTreeRst();

        List<QFirstRst> qFirstRstList = new ArrayList<>();

        QFirstRst humanFirst = new QFirstRst();
        humanFirst.setId("1");
        humanFirst.setLabel("human");

        List<QSecondRst> qHumanSecondRstList = new ArrayList<>();

        QSecondRst humanGuSecond = new QSecondRst();
        humanGuSecond.setId("11");
        humanGuSecond.setLabel("Gut Microbiota");
        List<QThirdRst> humanGuTreeList = associationDao.findTreeGutMicrobiota("human");
        humanGuSecond.setChildren(humanGuTreeList);

        QSecondRst humanMeSecond = new QSecondRst();
        humanMeSecond.setId("12");
        humanMeSecond.setLabel("Metabolite");
        List<QThirdRst> humanMeTreeList = associationDao.findTreeMetabolite("human");
        humanMeSecond.setChildren(humanMeTreeList);

        QSecondRst humanGeSecond = new QSecondRst();
        humanGeSecond.setId("13");
        humanGeSecond.setLabel("Gene");
        List<QThirdRst> humanGeTreeList = associationDao.findTreeGene("human");
        humanGeSecond.setChildren(humanGeTreeList);

        qHumanSecondRstList.add(humanGuSecond);
        qHumanSecondRstList.add(humanMeSecond);
        qHumanSecondRstList.add(humanGeSecond);

        humanFirst.setChildren(qHumanSecondRstList);

        qFirstRstList.add(humanFirst);


        QFirstRst mouseFirst = new QFirstRst();
        mouseFirst.setId("2");
        mouseFirst.setLabel("mouse");

        List<QSecondRst> qMouseSecondRstList = new ArrayList<>();

        QSecondRst mouseGuSecond = new QSecondRst();
        mouseGuSecond.setId("21");
        mouseGuSecond.setLabel("Gut Microbiota");
        List<QThirdRst> guTreeList = associationDao.findTreeGutMicrobiota("mouse");
        mouseGuSecond.setChildren(guTreeList);

        QSecondRst mouseMeSecond = new QSecondRst();
        mouseMeSecond.setId("22");
        mouseMeSecond.setLabel("Metabolite");
        List<QThirdRst> meTreeList = associationDao.findTreeMetabolite("mouse");
        mouseMeSecond.setChildren(meTreeList);

        QSecondRst mouseGeSecond = new QSecondRst();
        mouseGeSecond.setId("23");
        mouseGeSecond.setLabel("Gene");
        List<QThirdRst> geTreeList = associationDao.findTreeGene("mouse");
        mouseGeSecond.setChildren(geTreeList);

        qMouseSecondRstList.add(mouseGuSecond);
        qMouseSecondRstList.add(mouseMeSecond);
        qMouseSecondRstList.add(mouseGeSecond);

        mouseFirst.setChildren(qMouseSecondRstList);

        qFirstRstList.add(mouseFirst);

        qTreeRst.setData(qFirstRstList);

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qTreeRst);
        return  responseData;
    }

    private String combine(String gutmicro, String gutIId){
        if(gutmicro == null || "".equals(gutmicro)){
            return "<p></p>";
        }
        if(gutIId == null || "".equals(gutIId)){
            return "<p>" + gutmicro + "</p>";
        }else{
            String aTag = "<a target=\"_blank\" href=\""
                    + "https://www.ncbi.nlm.nih.gov/Taxonomy/Browser/wwwtax.cgi?id=" + gutIId + "\">" + gutIId + "</a></span>";
            String aTagStr = HtmlUtils.htmlUnescape("<p>" + gutmicro + " (" + aTag + ")" + "</p>");
            return aTagStr;
        }
    }

    public ResponseData<List<QSearchLikeRst>> processSearchGu(QSearchLikeRec data) {
        ResponseData<List<QSearchLikeRst>> responseData = new ResponseData<>();
        List<QSearchLikeRst> qSearchLikeRstList = new ArrayList<>();

        Integer type = data.getType();
        String typeStr = "";
        if(type == 1){
            //human
            typeStr = "human";
        }else if(type == 2){
            //mouse
            typeStr = "mouse";
        }else{
            //others
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        String rule = data.getKey();
        if(rule == null || "".equals(rule)){

        }else{
            rule = rule + "%";
        }

        qSearchLikeRstList = associationDao.findGutMicrobiotaLike(typeStr, rule);

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qSearchLikeRstList);
        return  responseData;
    }

    public ResponseData<List<QSearchLikeRst>> processSearchGe(QSearchLikeRec data) {
        ResponseData<List<QSearchLikeRst>> responseData = new ResponseData<>();
        List<QSearchLikeRst> qSearchLikeRstList = new ArrayList<>();

        Integer type = data.getType();
        String typeStr = "";
        if(type == 1){
            //human
            typeStr = "human";
        }else if(type == 2){
            //mouse
            typeStr = "mouse";
        }else{
            //others
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        String rule = data.getKey();
        if(rule == null || "".equals(rule)){

        }else{
            rule = rule + "%";
        }

        qSearchLikeRstList = associationDao.findGeneLike(typeStr, rule);

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qSearchLikeRstList);
        return  responseData;
    }

    public ResponseData<List<QSearchLikeRst>> processSearchMe(QSearchLikeRec data) {
        ResponseData<List<QSearchLikeRst>> responseData = new ResponseData<>();
        List<QSearchLikeRst> qSearchLikeRstList = new ArrayList<>();

        Integer type = data.getType();
        String typeStr = "";
        if(type == 1){
            //human
            typeStr = "human";
        }else if(type == 2){
            //mouse
            typeStr = "mouse";
        }else{
            //others
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        String rule = data.getKey();
        if(rule == null || "".equals(rule)){

        }else{
            rule = rule + "%";
        }

        qSearchLikeRstList = associationDao.findMetaboliteLike(typeStr, rule);

        responseData.setStatus(ReturnStatus.OK);
        responseData.setResultSet(qSearchLikeRstList);
        return  responseData;
    }


    public XSSFWorkbook show(int indexId) {
        List<Association> associationList = associationDao.findByIndex(indexId);
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Goods");// 创建一张表
        Row titleRow = sheet.createRow(0);// 创建第一行，起始为0
        titleRow.createCell(0).setCellValue("Human/Mouse");// 第一列
        titleRow.createCell(1).setCellValue("Gut Microbiota (ID)");
        titleRow.createCell(2).setCellValue("Strain");
        titleRow.createCell(3).setCellValue("Metabolite (ID)");
        titleRow.createCell(4).setCellValue("Gene (ID)");
        titleRow.createCell(5).setCellValue("Alteration");
        titleRow.createCell(6).setCellValue("PMID");
        int cell = 1;

        if(!associationList.isEmpty()){

            for(Association association : associationList) {
                Row row = sheet.createRow(cell);// 从第二行开始保存数据
                //humanMouse
                row.createCell(0).setCellValue(association.getHumanMouse());

                //Gut Microbiota(ID)
                String gutmicrobiota = association.getGutmicrobiota();
                String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                row.createCell(1).setCellValue(gut);

                //Strain
                row.createCell(2).setCellValue(association.getStrain());

                //Metabolite(ID)
                String metabolite = association.getMetabolite();
                String metabolitePubChemCid = association.getMetabolitepubchemcid();
                String me = deelStr(metabolite, metabolitePubChemCid);
                row.createCell(3).setCellValue(me);

                //Gene(ID)
                String gene = association.getGene();
                String geneId = association.getGeneid();
                String ge = deelStr(gene, geneId);
                row.createCell(4).setCellValue(ge);

                //Alteration
                row.createCell(5).setCellValue(association.getAlteration());

                //PMID
                row.createCell(6).setCellValue(association.getPmid());

               cell++;
            }
        }

        return wb;
    }

    public XSSFWorkbook browseDownLoadExcel(Integer type, String key, String value) {

        String typeStr = "";
        //根据传入参数判断获取大类型
        if(type == 1){
            //human
            typeStr = "human";
        }else{
            //mouse
            typeStr = "mouse";
        }

        List<Association> associationList = new ArrayList<>();

        switch (key){
            case "GutMicrobiota":
                associationList = associationDao.findListGutMicrobiota(typeStr, value);
                break;
            case "Metabolite":
                associationList = associationDao.findListMetabolite(typeStr, value);
                break;
            case "Gene":
                associationList = associationDao.findListGene(typeStr, value);
                break;
            default:
                associationList = new ArrayList<>();
                break;
        }

        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Goods");// 创建一张表
        Row titleRow = sheet.createRow(0);// 创建第一行，起始为0
        titleRow.createCell(0).setCellValue("Human/Mouse");// 第一列
        titleRow.createCell(1).setCellValue("Gut Microbiota (ID)");
        titleRow.createCell(2).setCellValue("Strain");
        titleRow.createCell(3).setCellValue("Metabolite (ID)");
        titleRow.createCell(4).setCellValue("Gene (ID)");
        titleRow.createCell(5).setCellValue("Alteration");
        titleRow.createCell(6).setCellValue("PMID");
        int cell = 1;

        if(!associationList.isEmpty()){

            for(Association association : associationList) {
                Row row = sheet.createRow(cell);// 从第二行开始保存数据
                //humanMouse
                row.createCell(0).setCellValue(association.getHumanMouse());
                //Gut Microbiota(ID)
                String gutmicrobiota = association.getGutmicrobiota();
                String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                row.createCell(1).setCellValue(gut);
                //Strain
                row.createCell(2).setCellValue(association.getStrain());
                //Metabolite(ID)
                String metabolite = association.getMetabolite();
                String metabolitePubChemCid = association.getMetabolitepubchemcid();
                String me = deelStr(metabolite, metabolitePubChemCid);
                row.createCell(3).setCellValue(me);
                //Gene(ID)
                String gene = association.getGene();
                String geneId = association.getGeneid();
                String ge = deelStr(gene, geneId);
                row.createCell(4).setCellValue(ge);
                //Alteration
                row.createCell(5).setCellValue(association.getAlteration());
                //PMID
                row.createCell(6).setCellValue(association.getPmid());
                cell++;
            }
        }

        return wb;
    }

    public XSSFWorkbook searchDownloadExcel(Integer type, String gutMicrobiotaSub, String metaboliteSub, String geneSub) {

        String typeStr = "";
        //根据传入参数判断获取大类型
        if(type == 1){
            //human
            typeStr = "human";
        }else{
            //mouse
            typeStr = "mouse";
        }

        if(gutMicrobiotaSub != null && "null".equals(gutMicrobiotaSub)){
            gutMicrobiotaSub = "";
        }
        if(metaboliteSub != null && "null".equals(metaboliteSub)){
            metaboliteSub = "";
        }
        if(geneSub != null && "null".equals(geneSub)){
            geneSub = "";
        }

        List<Association> associationList = new ArrayList<>();
        associationList = associationDao
                    .searchAssociation(typeStr, gutMicrobiotaSub, metaboliteSub, geneSub);

        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("Goods");// 创建一张表
        Row titleRow = sheet.createRow(0);// 创建第一行，起始为0
        titleRow.createCell(0).setCellValue("Human/Mouse");// 第一列
        titleRow.createCell(1).setCellValue("Gut Microbiota (ID)");
        titleRow.createCell(2).setCellValue("Strain");
        titleRow.createCell(3).setCellValue("Metabolite (ID)");
        titleRow.createCell(4).setCellValue("Gene (ID)");
        titleRow.createCell(5).setCellValue("Alteration");
        titleRow.createCell(6).setCellValue("PMID");
        int cell = 1;

        if(!associationList.isEmpty()){

            for(Association association : associationList) {
                Row row = sheet.createRow(cell);// 从第二行开始保存数据
                //humanMouse
                row.createCell(0).setCellValue(association.getHumanMouse());

                //Gut Microbiota(ID)
                String gutmicrobiota = association.getGutmicrobiota();
                String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                row.createCell(1).setCellValue(gut);

                //Strain
                row.createCell(2).setCellValue(association.getStrain());

                //Metabolite(ID)
                String metabolite = association.getMetabolite();
                String metabolitePubChemCid = association.getMetabolitepubchemcid();
                String me = deelStr(metabolite, metabolitePubChemCid);
                row.createCell(3).setCellValue(me);

                //Gene(ID)
                String gene = association.getGene();
                String geneId = association.getGeneid();
                String ge = deelStr(gene, geneId);
                row.createCell(4).setCellValue(ge);

                //Alteration
                row.createCell(5).setCellValue(association.getAlteration());

                //PMID
                row.createCell(6).setCellValue(association.getPmid());

                cell++;
            }
        }

        return wb;
    }

    public void browseDownloadTxt(HttpServletRequest req, HttpServletResponse resp, Integer type, String key, String value) {
        ResponseData rd=new ResponseData();
        List<Association> associationList = new ArrayList<>();
        /* BufferedWriter out=null;*/
        ServletOutputStream outSTr = null;// 建立;
        BufferedOutputStream buff = null;
        try{
            outSTr = resp.getOutputStream();// 建立;

            String typeStr = "";
            //根据传入参数判断获取大类型
            if(type == 1){
                //human
                typeStr = "human";
            }else{
                //mouse
                typeStr = "mouse";
            }

            switch (key){
                case "GutMicrobiota":
                    associationList = associationDao.findListGutMicrobiota(typeStr, value);
                    break;
                case "Metabolite":
                    associationList = associationDao.findListMetabolite(typeStr, value);
                    break;
                case "Gene":
                    associationList = associationDao.findListGene(typeStr, value);
                    break;
                default:
                    associationList = new ArrayList<>();
                    break;
            }
            //拼凑字符串
            StringBuilder content=new StringBuilder();
            content.append("Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID");
            content.append(System.getProperty("line.separator"));//换行
            if(!associationList.isEmpty()){

                for(Association association : associationList){
                    //humanMouse
                    content.append(association.getHumanMouse());
                    content.append(",");

                    //Gut Microbiota (ID)
                    String gutmicrobiota = association.getGutmicrobiota();
                    String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                    String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                    content.append(gut);
                    content.append(",");

                    //Strain
                    content.append(association.getStrain());
                    content.append(",");

                    //Metabolite (ID)
                    String metabolite = association.getMetabolite();
                    String metabolitePubChemCid = association.getMetabolitepubchemcid();
                    String me = deelStr(metabolite, metabolitePubChemCid);
                    content.append(me);
                    content.append(",");

                    //Gene (ID)
                    String gene = association.getGene();
                    String geneId = association.getGeneid();
                    String ge = deelStr(gene, geneId);
                    content.append(ge);
                    content.append(",");

                    //Alteration
                    content.append(association.getAlteration());
                    content.append(",");

                    //PMID
                    content.append(association.getPmid());
                    content.append(",");

                    content.append(" ");
                    content.append(System.getProperty("line.separator"));//换行
                }
            }
            String fileName= "data";
            resp.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".txt");
            resp.setContentType("text/plain");
            buff = new BufferedOutputStream(outSTr);
            buff.write(content.toString().getBytes(StandardCharsets.UTF_8));
            buff.flush();
            buff.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void searchDownloadTxt(HttpServletRequest req, HttpServletResponse resp, Integer type,
                                  String gutMicrobiotaSub, String metaboliteSub, String geneSub) {
        ResponseData rd=new ResponseData();
        List<Association> associationList = new ArrayList<>();
        /* BufferedWriter out=null;*/
        ServletOutputStream outSTr = null;// 建立;
        BufferedOutputStream buff = null;
        try{
            outSTr = resp.getOutputStream();// 建立;

            String typeStr = "";
            //根据传入参数判断获取大类型
            if(type == 1){
                //human
                typeStr = "human";
            }else{
                //mouse
                typeStr = "mouse";
            }

            if(gutMicrobiotaSub != null && "null".equals(gutMicrobiotaSub)){
                gutMicrobiotaSub = "";
            }
            if(metaboliteSub != null && "null".equals(metaboliteSub)){
                metaboliteSub = "";
            }
            if(geneSub != null && "null".equals(geneSub)){
                geneSub = "";
            }

            associationList = associationDao
                    .searchAssociation(typeStr, gutMicrobiotaSub, metaboliteSub, geneSub);

            //拼凑字符串
            StringBuilder content=new StringBuilder();
            content.append("Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID");
            content.append(System.getProperty("line.separator"));//换行
            if(!associationList.isEmpty()){

                for(Association association : associationList){
                    //humanMouse
                    content.append(association.getHumanMouse());
                    content.append(",");

                    //Gut Microbiota (ID)
                    String gutmicrobiota = association.getGutmicrobiota();
                    String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                    String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                    content.append(gut);
                    content.append(",");

                    //Strain
                    content.append(association.getStrain());
                    content.append(",");

                    //Metabolite (ID)
                    String metabolite = association.getMetabolite();
                    String metabolitePubChemCid = association.getMetabolitepubchemcid();
                    String me = deelStr(metabolite, metabolitePubChemCid);
                    content.append(me);
                    content.append(",");

                    //Gene (ID)
                    String gene = association.getGene();
                    String geneId = association.getGeneid();
                    String ge = deelStr(gene, geneId);
                    content.append(ge);
                    content.append(",");

                    //Alteration
                    content.append(association.getAlteration());
                    content.append(",");

                    //PMID
                    content.append(association.getPmid());
                    content.append(",");

                    content.append(" ");
                    content.append(System.getProperty("line.separator"));//换行
                }
            }
            String fileName= "data";
            resp.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".txt");
            resp.setContentType("text/plain");
            buff = new BufferedOutputStream(outSTr);
            buff.write(content.toString().getBytes(StandardCharsets.UTF_8));
            buff.flush();
            buff.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void downloadTxt(HttpServletRequest req, HttpServletResponse resp, int indexId) {
        ResponseData rd=new ResponseData();
        List<Association> associationList = new ArrayList<>();
        /* BufferedWriter out=null;*/
        ServletOutputStream outSTr = null;// 建立;
        BufferedOutputStream buff = null;
        try{
            outSTr = resp.getOutputStream();// 建立;
            associationList = associationDao.findByIndex(indexId);
            //拼凑字符串
            StringBuilder content=new StringBuilder();
            content.append("Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID");
            content.append(System.getProperty("line.separator"));//换行
            if(!associationList.isEmpty()){

                for(Association association : associationList){
                    //humanMouse
                    content.append(association.getHumanMouse());
                    content.append(",");

                    //Gut Microbiota (ID)
                    String gutmicrobiota = association.getGutmicrobiota();
                    String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                    String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                    content.append(gut);
                    content.append(",");

                    //Strain
                    content.append(association.getStrain());
                    content.append(",");

                    //Metabolite (ID)
                    String metabolite = association.getMetabolite();
                    String metabolitePubChemCid = association.getMetabolitepubchemcid();
                    String me = deelStr(metabolite, metabolitePubChemCid);
                    content.append(me);
                    content.append(",");

                    //Gene (ID)
                    String gene = association.getGene();
                    String geneId = association.getGeneid();
                    String ge = deelStr(gene, geneId);
                    content.append(ge);
                    content.append(",");

                    //Alteration
                    content.append(association.getAlteration());
                    content.append(",");

                    //PMID
                    content.append(association.getPmid());
                    content.append(",");

                    content.append(" ");
                    content.append(System.getProperty("line.separator"));//换行
                }
            }
            String fileName= "data";
            resp.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".txt");
            resp.setContentType("text/plain");
            buff = new BufferedOutputStream(outSTr);
            buff.write(content.toString().getBytes(StandardCharsets.UTF_8));
            buff.flush();
            buff.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                buff.close();
                outSTr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String downloadCsv(HttpServletResponse resp, int indexId) {
        List<Association> associationList = associationDao.findByIndex(indexId);
        String sTitle ="Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID";
        String fName ="data";
        String mapKey ="Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID";
        List<Map> dataList =new ArrayList<>();
        Map map =null;
        if(!associationList.isEmpty()){
            for(Association association : associationList) {
                map =new HashMap();
                //humanMouse
                map.put("Human/Mouse", association.getHumanMouse());
                //Gut Microbiota(ID)
                String gutmicrobiota = association.getGutmicrobiota();
                String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                map.put("Gut Microbiota (ID)", gut);
                //Strain
                map.put("Strain", association.getStrain());
                //Metabolite(ID)
                String metabolite = association.getMetabolite();
                String metabolitePubChemCid = association.getMetabolitepubchemcid();
                String me = deelStr(metabolite, metabolitePubChemCid);
                map.put("Metabolite (ID)", me);
                //Gene(ID)
                String gene = association.getGene();
                String geneId = association.getGeneid();
                String ge = deelStr(gene, geneId);
                map.put("Gene (ID)", ge);
                //Alteration
                map.put("Alteration", association.getAlteration());
                //PMID
                map.put("PMID", association.getPmid());
                dataList.add(map);
            }
        }
        try(OutputStream os = resp.getOutputStream()) {
            ExportUtil.responseSetProperties(fName,resp);
            ExportUtil.doExport(dataList,sTitle,mapKey,os);
            return null;
        }catch(Exception e) {
            System.out.println(e);
        }
        return"数据导出出错";
    }

    public String browseDownloadCsv(HttpServletResponse resp, Integer type, String key, String value) {

        List<Association> associationList = new ArrayList<>();

        String typeStr = "";
        //根据传入参数判断获取大类型
        if(type == 1){
            //human
            typeStr = "human";
        }else{
            //mouse
            typeStr = "mouse";
        }

        switch (key){
            case "GutMicrobiota":
                associationList = associationDao.findListGutMicrobiota(typeStr, value);
                break;
            case "Metabolite":
                associationList = associationDao.findListMetabolite(typeStr, value);
                break;
            case "Gene":
                associationList = associationDao.findListGene(typeStr, value);
                break;
            default:
                associationList = new ArrayList<>();
                break;
        }

        String sTitle ="Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID";
        String fName ="data";
        String mapKey ="Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID";
        List<Map> dataList =new ArrayList<>();
        Map map =null;
        if(!associationList.isEmpty()){
            for(Association association : associationList) {
                map =new HashMap();
                //humanMouse
                map.put("Human/Mouse", association.getHumanMouse());
                //Gut Microbiota(ID)
                String gutmicrobiota = association.getGutmicrobiota();
                String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                map.put("Gut Microbiota (ID)", gut);
                //Strain
                map.put("Strain", association.getStrain());
                //Metabolite(ID)
                String metabolite = association.getMetabolite();
                String metabolitePubChemCid = association.getMetabolitepubchemcid();
                String me = deelStr(metabolite, metabolitePubChemCid);
                map.put("Metabolite (ID)", me);
                //Gene(ID)
                String gene = association.getGene();
                String geneId = association.getGeneid();
                String ge = deelStr(gene, geneId);
                map.put("Gene (ID)", ge);
                //Alteration
                map.put("Alteration", association.getAlteration());
                //PMID
                map.put("PMID", association.getPmid());
                dataList.add(map);
            }
        }
        try(OutputStream os = resp.getOutputStream()) {
            ExportUtil.responseSetProperties(fName,resp);
            ExportUtil.doExport(dataList,sTitle,mapKey,os);
            return null;
        }catch(Exception e) {
            System.out.println(e);
        }
        return"数据导出出错";
    }

    public String searchDownloadCsv(HttpServletResponse resp, Integer type,
                                    String gutMicrobiotaSub, String metaboliteSub, String geneSub) {

        List<Association> associationList = new ArrayList<>();

        String typeStr = "";
        //根据传入参数判断获取大类型
        if(type == 1){
            //human
            typeStr = "human";
        }else{
            //mouse
            typeStr = "mouse";
        }

        if(gutMicrobiotaSub != null && "null".equals(gutMicrobiotaSub)){
            gutMicrobiotaSub = "";
        }
        if(metaboliteSub != null && "null".equals(metaboliteSub)){
            metaboliteSub = "";
        }
        if(geneSub != null && "null".equals(geneSub)){
            geneSub = "";
        }

        associationList = associationDao.searchAssociation(typeStr, gutMicrobiotaSub, metaboliteSub, geneSub);

        String sTitle ="Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID";
        String fName ="data";
        String mapKey ="Human/Mouse,Gut Microbiota (ID),Strain,Metabolite (ID),Gene (ID),Alteration,PMID";
        List<Map> dataList =new ArrayList<>();
        Map map = null;
        if(!associationList.isEmpty()){
            for(Association association : associationList) {
                map =new HashMap();
                //humanMouse
                map.put("Human/Mouse", association.getHumanMouse());
                //Gut Microbiota(ID)
                String gutmicrobiota = association.getGutmicrobiota();
                String gutmicrobiatancbiid = association.getGutmicrobiatancbiid();
                String gut = deelStr(gutmicrobiota, gutmicrobiatancbiid);
                map.put("Gut Microbiota(ID)", gut);
                //Strain
                map.put("Strain", association.getStrain());
                //Metabolite(ID)
                String metabolite = association.getMetabolite();
                String metabolitePubChemCid = association.getMetabolitepubchemcid();
                String me = deelStr(metabolite, metabolitePubChemCid);
                map.put("Metabolite(ID)", me);
                //Gene(ID)
                String gene = association.getGene();
                String geneId = association.getGeneid();
                String ge = deelStr(gene, geneId);
                map.put("Gene(ID)", ge);
                //Alteration
                map.put("Alteration", association.getAlteration());
                //PMID
                map.put("PMID", association.getPmid());
                dataList.add(map);
            }
        }
        try(OutputStream os = resp.getOutputStream()) {
            ExportUtil.responseSetProperties(fName,resp);
            ExportUtil.doExport(dataList,sTitle,mapKey,os);
            return null;
        }catch(Exception e) {
            System.out.println(e);
        }
        return"数据导出出错";
    }


    public ResponseData<CSubmitRst> processSubmit(CSubmitRec data) {
        ResponseData<CSubmitRst> responseData = new ResponseData<>();

        String gutmicrobiota = data.getGutmicrobiota();

        if(gutmicrobiota == null || "".equals(gutmicrobiota)){
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        String email = data.getEmail();
        if(email == null || "".equals(email)){
            responseData.setStatus(ReturnStatus.ERR0001);
            return responseData;
        }

        String metabolite = data.getMetabolite();

        String gene = data.getGene();

        String referencepmid = data.getReferencepmid();

        Submitinfo submitinfo = new Submitinfo();
        submitinfo.setEmail(email);
        submitinfo.setMetabolite(metabolite);
        submitinfo.setGene(gene);
        submitinfo.setGutmicrobiota(gutmicrobiota);
        submitinfo.setReferencepmid(referencepmid);

        int resultCode = submitinfoMapper.insertSelective(submitinfo);
        if(resultCode > 0){
            responseData.setStatus(ReturnStatus.OK);
            return responseData;
        }else{
            responseData.setStatus(ReturnStatus.ERR0002);
            return responseData;
        }
    }

    private String deelStr(String firStr, String secStr){
        if(firStr == null || "".equals(firStr)){
            return "";
        }else if(secStr == null || "".equals(secStr)){
            return firStr;
        }else{
            return firStr + " (" + secStr + ")";
        }
    }


}
