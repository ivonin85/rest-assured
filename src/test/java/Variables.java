public class Variables {


    String url = "https://biblio-online.ru/api/v1/content/0018100E-0698-4F60-95E4-1F064FF07C44";









    /** SQL запросы**/
    String selectFirst = "SELECT ca.ebs_user_id, eu.FullName, c.content_id, c.bname, c.bshortname, c.Bautor, c.bdescription, c.rpd_discipline_id, c.sef_url, c.enable_type_id, c.real_bnumber, c.preview_bnumber, \n" +
            "bp.posob_type_name, pb.publisher_name, pb.publisher_id, pb.izdatel_id, b.obl_type, b.Byear, b.BNumber, b.im_link, b.bcode, b.bibliographic_part1, \n" +
            "b.bibliographic_part2, bs.series_name, bs.series_id, c.age_limit, cv.video_review_link, bf.id AS book_id, i.izdatel_name, g.grif_name, obl.name AS obl_name\n" +
            "FROM Contents c\n" +
            "  JOIN contents_books cb ON cb.content_id=c.content_id\n" +
            "  JOIN Books b ON b.bcode=cb.bcode\n" +
            "  JOIN contents_authors ca ON cb.content_id=ca.content_id\n" +
            "  LEFT JOIN ebs_users eu ON ca.ebs_user_id = eu.ebs_user_id\n" +
            "  LEFT JOIN obl_type obl ON obl.obl_type=b.obl_type\n" +
            "  LEFT JOIN books_posob_types bp ON bp.posob_type_id=b.posob_type_id\n" +
            "  LEFT JOIN Publisher pb ON pb.publisher_id=c.publisher_id\n" +
            "  LEFT JOIN grifs g ON g.grif_id=b.griph_id\n" +
            "  JOIN content_holders_contents chc ON chc.content_id=c.content_id\n" +
            "  JOIN content_holders_content_folders hf ON hf.cohoco_id=chc.cohoco_id\n" +
            "  JOIN series bs ON bs.series_id=b.serie_id\n" +
            "  LEFT JOIN Izdatel i ON i.izdatel_id=pb.izdatel_id\n" +
            "  LEFT JOIN books_files bf ON bf.content_id=c.content_id\n" +
            "  LEFT JOIN contents_video cv ON cv.content_id=c.content_id\n" +
            "  WHERE b.bcode=441206\n" +
            "  ORDER BY c.bname\n" +
            "  LIMIT 1";

}
