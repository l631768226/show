package com.ly.show.dao;

import com.ly.show.mapper.AssociationSelectProvider;
import com.ly.show.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


import java.util.List;

public interface AssociationDao {

    /**
     * 根据条件查询Gene
     * @param type
     * @return
     */
    @Select("select Gene as value, `Index` as indexId, Id as id " +
                "from Association " +
                    "where `humanMouse` = #{type} " +
                    "and Gene <> '' " +
                        "group by Gene " +
                            "ORDER BY Gene ASC")
    List<SearchResultData> findGene(@Param("type")String type);


    /**
     * 根据条件查询Metabolite
     * @param type
     * @return
     */
    @Select("select Metabolite as value, `Index` as indexId, Id as id " +
            "from Association " +
            "where `humanMouse` = #{type} " +
            "and Metabolite <> '' " +
            "group by Metabolite " +
            "ORDER BY Metabolite ASC")
    List<SearchResultData> findMetabolite(@Param("type")String type);

    /**
     * 根据条件查询GutMicrobiota
     * @param type
     * @return
     */
    @Select("select GutMicrobiota as value, `Index` as indexId, Id as id " +
            "from Association " +
            "where `humanMouse` = #{type} " +
            "and `GutMicrobiota` <> '' " +
            "group by `GutMicrobiota` " +
            "ORDER BY `GutMicrobiota` ASC")
    List<SearchResultData> findGutMicrobiota(@Param("type")String type);


    @Select("select A.*, B.PMID from Association as A, Literature as B where A.`Index` = #{indexId} and A.`Index` = B.`Index`" )
    List<Association> findByIndex(@Param("indexId")int index);


    @Select("select * from Literature where `Index` = #{index}")
    Literature findLiterByIndex(@Param("index") Integer index);

    @Select("select * from Association where `Index` = #{index} and Id = #{id}")
    Association findByIndexAndId(@Param("index")Integer index, @Param("id")Integer id);

    @SelectProvider(type = AssociationSelectProvider.class, method = "searchAssociation")
    List<Association> searchAssociation(String type, String gutMicrobiota, String metabolite, String gene);



    /**
     * 根据条件查询Gene
     * @param type
     * @return
     */
    @Select("select Gene as label, `Index` as indexId, Id as id " +
            "from Association " +
            "where `humanMouse` = #{type} " +
            "and Gene <> '' " +
            "group by `Gene` " +
            "ORDER BY Gene ASC")
    List<QThirdRst> findTreeGene(@Param("type")String type);


    /**
     * 根据条件查询Metabolite
     * @param type
     * @return
     */
    @Select("select Metabolite as label, `Index` as indexId, Id as id " +
            "from Association " +
            "where `humanMouse` = #{type} " +
            "and Metabolite <> '' " +
            "group by `Metabolite` " +
            "ORDER BY Metabolite ASC")
    List<QThirdRst> findTreeMetabolite(@Param("type")String type);

    /**
     * 根据条件查询GutMicrobiota
     * @param type
     * @return
     */
    @Select("select GutMicrobiota as label, `Index` as indexId, Id as id " +
            "from Association " +
            "where `humanMouse` = #{type} " +
            "and `GutMicrobiota` <> '' " +
            "group by `GutMicrobiota` " +
            "ORDER BY `GutMicrobiota` ASC")
    List<QThirdRst> findTreeGutMicrobiota(@Param("type")String type);



    /**
     * 模糊查询Gene
     * @param type
     * @return
     */
    @Select("select Gene as value " +
            "from Association " +
            "where `humanMouse` = #{type} " +
            "and Gene like #{rule} " +
            "group by Gene " +
            "ORDER BY Gene ASC")
    List<QSearchLikeRst> findGeneLike(@Param("type")String type, @Param("rule") String rule);


    /**
     * 模糊查询Metabolite
     * @param type
     * @return
     */
    @Select("select Metabolite as value " +
            "from Association " +
            "where `humanMouse` = #{type} " +
            "and Metabolite like #{rule} " +
            "group by Metabolite " +
            "ORDER BY Metabolite ASC")
    List<QSearchLikeRst> findMetaboliteLike(@Param("type")String type, @Param("rule") String rule);

    /**
     * 模糊查询GutMicrobiota
     * @param type
     * @return
     */
    @Select("select GutMicrobiota as value " +
            "from Association " +
            "where `humanMouse` = #{type} " +
            "and `GutMicrobiota` like #{rule} " +
            "group by `GutMicrobiota` " +
            "ORDER BY `GutMicrobiota` ASC")
    List<QSearchLikeRst> findGutMicrobiotaLike(@Param("type")String type, @Param("rule") String rule);



    /**
     * 根据条件查询Gene
     * @param type
     * @return
     */
    @Select("select A.*, B.PMID " +
            "from Association as A, Literature as B " +
            "where A.`humanMouse` = #{type} " +
            "and A.Gene = #{value} " +
            "and A.`Index` = B.`Index` " +
            "ORDER BY A.`Index` ASC")
    List<Association> findListGene(@Param("type")String type, @Param("value") String value);

    /**
     * 根据条件查询Metabolite
     * @param type
     * @return
     */
    @Select("select A.*, B.PMID " +
            "from Association as A, Literature as B " +
            "where A.`humanMouse` = #{type} " +
            "and A.Metabolite = #{value} " +
            "and A.`Index` = B.`Index` " +
            "ORDER BY A.`Index` ASC")
    List<Association> findListMetabolite(@Param("type")String type, @Param("value") String value);

    /**
     * 根据条件查询GutMicrobiota
     * @param type
     * @return
     */
    @Select("select A.*, B.PMID " +
            "from Association as A, Literature as B " +
            "where A.`humanMouse` = #{type} " +
            "and A.`GutMicrobiota` = #{value} " +
            "and A.`Index` = B.`Index` " +
            "ORDER BY A.`Index` ASC")
    List<Association> findListGutMicrobiota(@Param("type")String type, @Param("value") String value);


}
