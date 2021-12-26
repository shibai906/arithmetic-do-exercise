package com.zhao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2021-09-08 23:46
 * @description
 **/
public class TestAA {

    static String string = "https://aisite.wejianzhan.com/site/wjz3morx/cbce1512-71b1-412b-9d5b-7ac63797b5e5?fid=nH0krH6Lrjf4nHRYrHndrjD4PjKxnWczg1n&ch=4&bfid=fbuFw0cKIZiUgP9TBmY00P300sZAx0_asUa0jfs0000T33g7w6000Ks0360i_PxPVeXBd5gjVQgLsrvk4Qopn78SJdY6_qH2__rYEtMidnWj_PXLCVHdseHwSUZb8VJLCB1N3oWvEQ1ZzTzodPeKz4w4200\n" +
            "https://qianhu.wejianzhan.com/site/wjz88q5w/51efa277-dd66-4e23-9e43-e60369f2368a?fid=rH6znjTdrjTdPWT1PjT3PHDLr7tznWFxns&ch=4&bfid=fbuFw0cKhVUexs4miC600P300sAkq0CakAZ1Qss000KalzJoi0000Ks0360R8QlOkVZgdJQHstJzseHiJIx88_nYYEydsQXBYIxHstJzseHiJivdqtjVYEydsQXBYIXdkPa9sSeNYaLi8epCYJJt_nJkVxx0ex_9_X3\n" +
            "https://aisite.wejianzhan.com/site/wjzllkix/d0f4f291-4542-4a72-9bae-4adfcdd8a2da?fid=nHD1rHfLnjc4PH04PHckn16YrHwxnWczg1c&ch=4&bfid=fbuFw0cKOEpmR5mIcG300P3006AP8fRaWkvMP6s000jQthOOi0000Ks03s0idqr4onHpk2ikCIHdseidqtjVFPxH8pzkvoA9d5gjVQAWYx66zrXl1oAWYxWaYUrzkrre3TQs5eyzMUm&bd_vid=nHD1rHfLnjc4PH04PHckn16YrHwxnWczg1FxnH0s\n" +
            "https://aisite.wejianzhan.com/site/wjzqyj6w/762ecc2c-0489-4aec-8731-e69f9a36a1e5?fid=rjcvPj6snHDdP1nLrjm3njc1r7tznWFxnf&ch=4&bfid=fbuFw0cKoBgQFPd3_Mc00P300fZzZx0KObpDr0s0000spX0gif000Ks03s0RV8jDY_Qw_eQRqTrYVxx0eUEy8QfGsVA1_ogDVxx0eUXqVl6V_lr1dPgBdVU2_teEQUjo85URsoeP8_5KzzA2EbSa\n" +
            "https://aisite.wejianzhan.com/site/wjz35bwx/5e8dc01c-a785-4381-9ae3-aab845310a6e?fid=P1msrjn4PH0YPW6dnWfLPHbLndtznWFxnf&ch=4&bfid=fbuFw0cKwUkeeEVz-hb00P300fZyIf3ayINg50s000a1oFunif000Ks0360pEPxgVnOuEXAqvo5RzoQjVP2GEtMidnhBEXDsd_ltdqXY1qhq3ULpQUePdXQjVQ1zVpR_drxyJog0E_vz8qxxdXQjVQU61XHaVtZQ2JUALf\n" +
            "https://aisite.wejianzhan.com/site/wjzy0p0w/2e8c623c-c1fe-4ba6-b103-e0d3cc9df12e?fid=P1cknHcYP1cdPj6vnjcYPWnkrNtznW9xnf&ch=4&bfid=fbuFw0cKQldY4iVODvf00rf00fDFjwnaGImz5ss000KiEb-sif000Ks0360iEPxgVnOuEXAqvVQezorqSe1FQQ1gdeH5vIHdseisea12dQoTV8aseQXCseEHsz1y_UyqYt5N3oWvY2AseQXCndxyj6\n" +
            "https://aisite.wejianzhan.com/site/wjz35bwx/277c26d2-acbc-49ea-9099-0f1d7097052d?fid=P1fsPWcsnWTLPj63n10sPHTzr7tznWFxnf&ch=4&bfid=fbuFw0cKc5NGAztXzAm00P300fZyIf3a1qNg50s000jFSGunif000Ks03602EPXO8VZ5dVWataHHYQ1gEeoRqTrY_rsO8rUQLtHWYo83qo1zVpydkQojVlWgYzAOmDB5\n" +
            "https://aisite.wejianzhan.com/site/wjzcedwx/4cf43e0a-471b-4055-8111-b35d1eee43cf?dynType=2&dynId=dyn.1_exp.1&fid=rjczrjR3nHRLn1T1nj6dnWbznNtYnjNxnf&ch=4&bfid=fbuFw0cKryaP2dWQngc00FRK0fDd2f3andjDr6s0000sWRbdif000Ks0360mEXAqvVjREPxgVnOudVX3sqHdseHy1_ZAPUL9EIofdQ1gdeH5vTOudVxy1_ZA5e1gdeiq3ULp_J2z8eOFkTc_dI2vdQvCY8hlLQ1zVpR97fgCS6\n" +
            "https://aisite.wejianzhan.com/site/wjz35bwx/5e8dc01c-a785-4381-9ae3-aab845310a6e?fid=rjnvrjf4njTYP1D1nHmzPjmzndtznW9xnf&ch=4&bfid=fbuFw0cKoL1_D5OucMf00rf00fZyIf3aYPNg50s000K_YGunif000Ks0360iEPxgVnOuEXAqvVQezorqSe1F2o1gdeH5vUL9EIoRqTrY1O81Oiz34_Exkr5i8eWvE52dGUgD8_rLJPxHcwg2YUb\n" +
            "https://aisite.wejianzhan.com/site/wjz35bwx/277c26d2-acbc-49ea-9099-0f1d7097052d?fid=rjnkPHRdPWfsnjnLPjR1nHnvn-tznWFxnf&ch=4&bfid=fbuFw0cKc_RnaML2uMn00P300fZyIf3aGVNg50s0000Br4Inif000Ks0360fEPXO8o5RzoQjVnJ118Slsz-U_IBOV7Y6VT5Kze1gEeow1qUmsE0Od5gjVQQ7kPzls1SqCUSd1_JYt2mYV_t\n" +
            "https://aisite.wejianzhan.com/site/wjz35bwx/277c26d2-acbc-49ea-9099-0f1d7097052d?fid=P16dn16snWDsrjn1P101P1m3n7tznW9xn6&ch=4&bfid=fbuFw0cKT2Ab0v95Ohs00rf006ZyIf3a9VNg50s000KcH4Inif000Ks0360nEPXO8oE9V2EcE_QsFQgjsT8tdeSld5gjVQj_5q5fzoQjVQXqVlWNleUREPXO8_Qs5OJz4wf\n" +
            "https://aisite.wejianzhan.com/site/wjzcedwx/6b48f90c-8f67-4227-ae0f-52737708f718?fid=rjfYrjn3PWDzrjcYrjTdnj6Ln-tYnjNxnf&ch=4&bfid=fbuFw0cKAnrpDvzz5MR00FRK0fDd2f3a2NZDr6s000Kmwasdif000Ks0360gEPXtqToZzoQjVQ29QP5fzoQjVPpBdefkzoQjVnoZEPXtqI5fzoQjVPpBdefOEPXtqU2B_o8OzTgaQPgiVViqJPQG8Vzttoy-ciQSHvT\n" +
            "https://aisite.wejianzhan.com/site/wjz91dwx/26de49b4-7c45-4d8f-9f82-a3563a5c84b4?fid=nH04njfzn1TvP16LnjT3PWcYnW7xnWczg1c&ch=4&bfid=fbuFw0cK-XE5iyyBR4T00P3006Aa203a2tYrF6s000aS4bsIi0000Ks0360nzJxjLtZQd5gwSUj_2tJMsqSdkPUrsTpseQXCQUWhzqOD3q2e85pttoy-EX2Sq_JMsqSdkQXCdq5Zv14A&renqun_youhua=2955844\n" +
            "https://aisite.wejianzhan.com/site/wjz91dwx/26de49b4-7c45-4d8f-9f82-a3563a5c84b4?fid=rH0srHTvnjR3PHDYnjf4n1f4P7tznWFxn6&ch=4&bfid=fbuFw0cKV-zIPcfuagY00P3006Aa203a1TmrF6s000juRYCIi0000Ks0360RzJxjLtoZzoQjVPiVYEQiOTUsVTf8zJxjLtWM8_ldqqZ3QUWhzqOD3q2e85pdqtjVzJxjLegDVevs8aLcVtJdEtMidFMv2hb&renqun_youhua=2955844\n" +
            "https://aisite.wejianzhan.com/site/wjz01cbx/e614c348-5676-465b-ab8b-5a2d339cdd9b?fid=P1nYn1mzn1T4PH6kPjT3Pj0sr7tznWFxnf&ch=4&bfid=fbuFw0cKa7z-cXO2lyR00P300fZGV6saBvbQ2ss000K_lr--i0000Ks0l00DerlsLz5_eojxVTHNOTBLerlsLeXqVl6VET1D3q2edIattoy-erlsLtD265m\n" +
            "https://qianhu.wejianzhan.com/site/wjzwjndx/cd3db109-023b-4059-ac67-1b7ff49fc33d?fid=P1b1Pj0LP1n1PW6drjcdrHDkr7tznWFxn6&ch=4&bfid=fbuFw0cKo8eGcYvKAv300P3006A5PscaD5Zuc0s000K9Vxorws000Ks0l00nVo8v8qHdseH5Se5q2oxUVn1c4eorerl1OUxUVn1seoiEQULnkrn185UNOTBLz2yv8egDEQ1ZzRtGDC0&bd_vid=P1b1Pj0LP1n1PW6drjcdrHDkr7tznWFxn-tknj0\n" +
            "https://aisite.wejianzhan.com/site/wjzlqfwx/a0950fe0-b0b8-4ead-9107-f901af57d08a?fid=rHDsrHTLrHbLPHczP16vrHT1rNtznWFxns&ch=4&bfid=fbuFw0cK23G_QuqsUZ300P300sZk2s3a_nXscss000K7bEH4ws000Ks0360RzJxjLtoZzoQjVPiVYEQiOTUsVTf_zJxjLtoZzoQjVPiVYEQiOTUsVTfOzlOZ_P5jdX23qoXqVl69E52dGTJdYtrIl0Ul\n" +
            "https://qianhu.wejianzhan.com/site/wjzkdvmx/b6db3186-cd33-413c-ad86-bdd7e1ef3d25?fid=PWb3PWTsPj6kPj61PWnLrjnzr7tznW9xn6&ch=4&bfid=fbuFw0cKvAoNj65jqy000rf006DsHkDapxx7rss0000KQH9Dif000Ks0360xzl8L1_eAsrLRqoU6d5pYd_JzseHi3_8tQPZ5dVWata2L1o2O1_U0eIHvV8jASPUgVt3O_oEHstgaQnx9zthq3oevJdNDCf\n" +
            "https://aisite.wejianzhan.com/site/wjzoa84v/e585a3c9-8356-4fb8-baf6-bf27ccc429f5?fid=nHDznjmYnj63PWR4PHc1PH6YPW-xnWczg1D&ch=4&bfid=fbuFw0cKwXj6HMYG9u_00P300fAUZXDKJkjnn6s0000Dnujri0000Ks0360f1OBYoUgDdExiJVpBdeH2k1a34_Exkr5i8eWv1OBYoUgDVl2zCIpBdeH2ktJzseidkQXqVl6_Yo8vJP2JzVyzvaZs91-g\n" +
            "https://aisite.wejianzhan.com/site/wjz7q8cx/1e6e97ff-11c8-420b-a3db-156f8989cd14?dynType=2&dynId=dyn.1_exp.2&fid=rHRsnHb1PWf1rjT3n1fdPWTLP7tznWNxn6&ch=4&bfid=fbuFw0cKKWmZ0PhCLmn00rD006DbLsDaEj6cDss000KT3hDwws000Ks0360n_PxPVeXB_qH2__rYnU5RzoQjVQrb_PxPVeXBQIgB85pLEUXCE_vOzIQRznrsdeXBdlJlvB1R4eWjdJJdsaZShEz3&bd_vid=rHRsnHb1PWf1rjT3n1fdPWTLP7tznWNxn-tknj0\n" +
            "https://aisite.wejianzhan.com/site/dl4.hqyt.com/22cef95a-c9fb-4363-97c6-c90e11042370?1=zhiming&e_creative=51114433591&fid=nHD1PWmvrH0knjb1PWm4nWfLnWKxnWczg1c&ch=4&bfid=fbuFw0cK_5gamAlmEGY00P3006ZHnenKPdzC46_000a91a0e26000Ks0000ndrxf8IHdseHy1_ZAno24zxpdkQojVeYVng3zVqUyYeePzXHKzeLnkr5i8eWvdXQNYQ5yE_rsleWvdV5idnM5l2T-P6&bd_vid=nHD1PWmvrH0knjb1PWm4nWfLnWKxnWczg1FxnH0s\n" +
            "https://aisite.wejianzhan.com/site/wjzl1p0w/588dae97-c699-473e-b340-a86c76aa6717?fid=P1bkPjTzrHnknWD3rHD1P1nsP-tznWFxnf&ch=4&bfid=fbuFw0cKh_7MAhjDdhY00P300f7IHE6KexzkPfs000j9X5Ozi0000Ks0360RVtlzEqxvzoQjVQ1__8MgeVXtzQTmVteyCo1__8bVQQ2ezVU2qizz8qX9dQC_UAgWFf\n" +
            "https://aisite.wejianzhan.com/site/wjzed6sx/3d9073c8-2de9-42bd-a2bf-8ef85eba5b12?fid=nH0dP1R4nW6YP1DvrHDdnWRYnjKxnWczg1n&ch=4&bfid=fbuFw0cKA5YTHXbSkuc00P300sDCPfsaXpXAQfs000jtm-Jri0000Ks0360iVtlzEezz_JAdkPHMkVoyCVXYnQxrEXAqvV2Jd_eKk_QscAjnOI2qdEUHsqUfYovdqtjVmQLpEXDz85URs_OezJxKz1CBTRs\n" +
            "https://aisite.wejianzhan.com/site/wjzj1dwx/71150e8c-ddd4-435e-847a-a3bfba08e3d8?fid=nH0dP1R4nW6YP1DvrHDdnWRYnjKxPj0dg1D&ch=4&bfid=fbuFw0cKA5YTHXbSkuc00FRK0fAj203axApqFfs000aMmF_yi0000Ks0360iVtlzEezz_JAdkPHMkVoyCVXYPUxr_oSq3ULpYqj2__rYdJQgVPHdsei3knMA_TBq1eoj5eSYdXQ0ez1c4eordxLcVtB-_OYO7uZwl6\n" +
            "https://aisite.wejianzhan.com/site/wjzumtzx/f9659ed4-caaf-4797-9974-ace595186127?fid=nHD3rHc4njczrjcLPHcdPWTkrH7xnWc3g1D&ch=4&bfid=fbuFw0cK-zxhu4YHj2R00rf00fZ6eK0ag5W8P0s00004APHMi0000Ks0360Rdn2SoU2e8XUazToZzoQjVPiVYEcG_oE0VPHaEJLRqTrY_rs__lr1dPgBnqUyzo5rezzlteEpdJJdsnLVsTVYOjzu\n" +
            "https://qianhu.wejianzhan.com/site/wjzc3lkx/70562446-b68d-42fa-9f28-736b3aea6dca?fid=P10Ynjb3nWm1PWcvnjDLrHRYr7tznWFxn6&ch=4&bfid=fbuFw0cKgjeeFvXmVhD00P3006D4IsmaTs6Fn6s0000sGkL7i0000Ks0360mz284So1gdeH5vTg7sO8dvV2esOEiEIilFQ1gdeH5vIa9EXAqv_WM8_ey1oE7sT_Od5gjVnOezp2q3ULpcpKivq6\n" +
            "https://qianhu.wejianzhan.com/site/wjzc3lkx/70562446-b68d-42fa-9f28-736b3aea6dca?fid=rHfdn1fkrjTdrHR1nWndnHD1ndtznWFxnf&ch=4&bfid=fbuFw0cKMmes6bu2nmn00P300fD4IsmaG0bFn6s000alE9L7i0000Ks0000iEPxgVnOuEXAqvV5f1PEPVQWfcnAtYPitdqXY1qhq3ULp8SZPVnQs5e84dPJdzQgcEefOSa7iif\n" +
            "https://aisite.wejianzhan.com/site/wjzp1p0w/4d24f2c3-db9c-4e54-b516-55fa4bf105e0?fid=rH04rjDLPH6zrjRkP1mzrjbkn7tznWFxn6&ch=4&bfid=fbuFw0cKeJEyromvfL300P300679HE6KFwCSn6s0000fjYHci0000Ks0360REPxgVnOuElJdVVjCYJJv3nMukl3Gyexy1SdIcnoyzEgj8qUr8_rdkPUrEPxgVnOuEP83ti1Z3TEF85h1Oi7zuYXG\n" +
            "https://aisite.wejianzhan.com/site/wjzp1p0w/4d24f2c3-db9c-4e54-b516-55fa4bf105e0?fid=PWbdP1b4rjRdrHfsrjnvn1bsPNtznWFxns&ch=4&bfid=fbuFw0cK6wbLcI5AWv000P300s79HE6KFwCSn6s0000wjYHci0000Ks0360mEPxgVnOudOU2d_odYrWiJoU6zIhLYI5jQN8Ld_OVgij2d_odseEy1oojVTHy1o1gdeH5vU1U85Av3nMuQnx9zth3SU5qcxQsMqT\n" +
            "https://aisite.wejianzhan.com/site/wjzdyj6w/d91ca2b7-f81a-48ab-849b-7ebb149daaba?fid=nHDvnWDvnHfLnjTsrH0YPjb4njIxnWczg1D&ch=4&bfid=fbuFw0cKtSyRW0K7i2D00P300fZhZx0KSjYDP0s0000QEUoUi0000Ks0360wzxpz8eojYqjDkPaGdJQgVjtdzxpz8eojzoQjVPpbdef6doEHYj7SnoxydVnOET1D3q2e85pLEUXCzn5D31fdVqUyYqQRzTtKkZgX\n" +
            "https://aisite.wejianzhan.com/site/wjz9dhnw/2af263f9-9240-4d22-939b-0d4e0dcce543?fid=nHDvnWDvnHfLnjTsrH0YPjb4njIxnWczg1n&ch=4&bfid=fbuFw0cKtSyRW0K7i2D00P300s7Anr3KkCFfP0s000at2bOxi0000Ks0360wzxpz8eojYqjDkPaGdJQgVjtkzxpz8eojdJQgVajy8q5fng3zVqUyY1Sq1nHWYo83qoXqVlWcstHWPjyLdVUHYVHF1tQYWBs\n" +
            "https://aisite.wejianzhan.com/site/wjz06nbx/63a436f7-4f7c-4cf8-ba25-1b6cafea2215?dynType=2&dynId=dyn.1_exp.1&fid=P1fvPjD3PH6drHf4PH0drjfYPNtznWFxns&ch=4&bfid=fbuFw0cKjNzzKZ3I-hT00P300sAC36satvt2Zss000aM94adws000Ks0360rd5gwSTOe_OLFvTHJ_PTJ8V1Dl_x9E_LFvTHJ_PXLCVHdseiseavsdeXBVTHRoIQzEoM2kz38QB38NllMK0&renqun_youhua=2947154\n" +
            "https://aisite.wejianzhan.com/site/wjzg6gsx/c4bc2e82-2186-460f-9192-95e2f50979be?fid=rj0YnWm1n1DLnH04nHb4n104rNtznWFxn6&ch=4&bfid=fbuFw0cKa12v4RD_Myt00P3006Z_D6sa0cCrr6s000KyQ8RJif000Ks0360REPxgVnOuEXAqvo2ekPz1dnJzsefSEPxgVnOuVTiq3ULp_oEDLQ5RzoQjVnox__8l1T888x_OseOneP5jdX23qoXqVl6_EXAqv_QqsEL5StJMsTVMQ4oH\n" +
            "https://aisite.wejianzhan.com/site/wjzy0p0w/2e8c623c-c1fe-4ba6-b103-e0d3cc9df12e?fid=rjcYPjDkn1RvnWTknWfdn161rNtznWFxn6&ch=4&bfid=fbuFw0cK1eFY2uE4pZc00P300677HE6KlMRbrss000jcAOblif000Ks0360xEPXO8o29z_x2__rYd2LitVQqkEadka1DLPUr8_5atazdstZQEPXO8o29YJoRqTrYd_3OET1D3q2e85pLEUXCQIxRzXvSoTjlVqU5eHHk19t\n" +
            "https://aisite.wejianzhan.com/site/wjzo1p0w/2cbd10b8-af94-4edd-be7b-772048f5e839?fid=rH0srHDvPjDYP1n4n1Ddn10Ln7tznW9xn6&ch=4&bfid=fbuFw0cKQ_BPr0OeKMY00rf0067xHE6KiMvSnss000jCbdEui0000Ks0360r8QlOkVZgdJQRqTrY_rsGYEydsP5fYIxyCVHdseHy1_ZA5tED85Ucst8qV2UrLVZgVTilseXqVl9n6kKZ\n" +
            "https://aisite.wejianzhan.com/site/wjz8kfwx/895a74ec-3201-4e5a-a6d8-f987ab930468?fid=rj0vrHcznWDznjm4n1R3nWR4r7tznWFxnf&ch=4&bfid=fbuFw0cKKb8JFTiBSvt00P300fDV2s3aNOiNnss000aMGoHgi0000Ks0360rd_zYoegDdJQgVQZV1qmJd2L0VPUnV2OyCVXYcP5jdX23qoXqVl6_YoENYQ5q5qghz_xnJejYsT_9asxv80&bd_vid=rj0vrHcznWDznjm4n1R3nWR4r7tznWFxnNtknj0\n" +
            "https://aisite.wejianzhan.com/site/wjz8kfwx/895a74ec-3201-4e5a-a6d8-f987ab930468?fid=rjRzrjRvnWnkrH0vrHmkPWDsPdtznWFxn6&ch=4&bfid=fbuFw0cKlkxVnjl2yLm00P3006DV2s3a1EiNnss000a6CeHgi0000Ks0360Rd5gjVngfV_OgdQzlVT5KzqUnV2tvd2L0VPHdseH7YQU5dqit8ogjsTEy1QiEcP5jdX23qoXqVl6_YoENYQ5q5qghz_xnJejYsT_9w0gH60&bd_vid=rjRzrjRvnWnkrH0vrHmkPWDsPdtznWFxn-tknj0\n" +
            "https://aisite.wejianzhan.com/site/wjzy0p0w/2e8c623c-c1fe-4ba6-b103-e0d3cc9df12e?fid=nHDYnWfsPWnLP1TYnWb3rjmsPWKxnWczg1c&ch=4&bfid=fbuFw0cKUFfITgGVBG300P300677HE6KjMRbrss0000plOblif000Ks0360fEPxgVnOuVTHyqq2JdJQgVj2tdqXY1qhtdqXY1qMHYnJzseHyCVXYQI5fzoQjVQoj_rzLJjON3oWvVevLJQQ7EeOAdv_kyeD\n" +
            "https://aisite.wejianzhan.com/site/wjzbkwox/c41b1106-4751-4aa9-9b68-bc24cf3da971?fid=nHDzrHbLrjDLrHbznHf4njT4nW-xPj0dg1D&ch=4&bfid=fbuFw0cKAf29IpLWYFs00FRK0fD9z66aBpOK7fs000jY6U0lws000Ks0Ss0AzXiSJqAJnTe2rBjF4QloYqjwJ_oZzoQjVPiVYEcOdXU2VUxy1SeF4QloYqjwJ_oZzoQjVPiVYEFYnsRF\n" +
            "https://aisite.wejianzhan.com/site/wjzov5kx/8f0f5ef0-06ca-4951-a672-63f79e094630?fid=nHDYrjTLnjDsrjn4PHmkPHRdnj-xnWczg1n&ch=4&bfid=fbuFw0cKIufHXYyjUFt00P300sZjSfma3hGtD0s0000SmMHow6000Ks0Ss02YPi4G_HTdTSsoiefdPjR8pUDLPg5_2Y_kPjcztpWzrvzJo2ekE0OseOneP5jdX2LJPxH8Vz4LP5jzKgd8f\n" +
            "https://aisite.wejianzhan.com/site/wjzsv5kx/ac7790cb-6999-4ad4-aae2-629ff7424226?fid=nHc1nHR3PWb1PHmvPW0YrHfYnHKxnWczg1c&ch=4&bfid=fbuFw0cKi9jXISLKlJC00P3006ZcSfmaXEfgDfs000j9Gl51w6000Ks0Ss0RYEgDYEjSYxxHstJzseHiJIUrsTmJYEgDYEjSYxxRqTrY_rsVzti3qo2qd8Wc1PX9QnWjk5Jt3Tvh_rEfCTJkHSS8Bf\n" +
            "https://aisite.wejianzhan.com/site/wjzsv5kx/ac7790cb-6999-4ad4-aae2-629ff7424226?fid=nHcsnHRYrjD1njm3P16vrj0knWNxnWczg1c&ch=4&bfid=fbuFw0cK5u1uxupfElm00P3006ZcSfma6R0gDfs000j8VJQ1w6000Ks0Ss0AvQoPln1U7TWq85pvoqxL8nHFkVHMUnMb8xvOerbPB1C\n" +
            "https://aisite.wejianzhan.com/site/wjzj1dwx/71150e8c-ddd4-435e-847a-a3bfba08e3d8?fid=nHDknH63P1TkP1bsPWcvnjfLPHNxnWc3g1D&ch=4&bfid=fbuFw0cKYdn4HScEHGC00rf00fAj203apApqFfs0000vyu_yi0000Ks0360RVterk_jVd5UZEtoZzoQjVPQBzes4VtlzEteAsrLRq_XO8_vq3ULpz_x2__rYd2LitWSLC_OyYo83qo1zVpy3knMAVtlq3ULpVTiLEUXCTlqti6\n" +
            "https://aisite.wejianzhan.com/site/wjz2chnw/d2effc25-bf0f-4e18-8525-f54234bf057b?fid=nH03rHfYPWbLP1m1PW0zPjfzrj-xnWczg1n&ch=4&bfid=fbuFw0cKfmf8Hco8nFT00P300sD-nr3KuKBCQss000jkJDhCi0000Ks04s0fYPi4G_HT1t2qVIHdseisejHfdQhhkP15sovdd5gjVQj_5t5ozXfEzoAt4QUnd5gjVQj_5zLN3oWvVevs8QOFYVH2dnoRhRUq60\n" +
            "https://aisite.wejianzhan.com/site/wjza9iew/419b3c9a-aa04-4679-8f04-c14d020d311b?fid=rHRsnjRYPjRzn1Tsn1TvPjc4ndtznWFxn6&ch=4&bfid=fbuFw0cKwRR-9rBvvcn00P3006AC3EYKW3tpF6s000jZZv6Xi0000Ks0400fV5rk3e5vYpo5zoo__oEPVjSYteZW_OUwJ_O288zz8tvYseEHYPUnV2O2ktJzseHwSIxHVTf_Yo83qoxZ_lrttoy-VTiLEUXCVxx0eIUnV2SbTSZk\n" +
            "https://aisite.wejianzhan.com/site/wjza9iew/419b3c9a-aa04-4679-8f04-c14d020d311b?fid=rHRsnjRYPjRzn1Tsn1TvPjc4ndtznWFxn6&ch=4&bfid=fbuFw0cKwRR-9rBvvcn00P3006AC3EYKW3tpF6s000jZZv6Xi0000Ks0400fV5rk3e5vYpo5zoo__oEPVjSYteZW_OUwJ_O288zz8tvYseEHYPUnV2O2ktJzseHwSIxHVTf_Yo83qoxZ_lrttoy-VTiLEUXCVxx0eIUnV2SbTSZk\n" +
            "https://isite.baidu.com/site/wjzvztqx/ba9bf601-eaf5-4de8-a235-695997d9644b?fid=nH0LnHcLrHmsn1f1njRvn1csPWFxnWcdg1c&ch=4&bfid=fbuFw0cK5BT00jkOJ4f00rD006ZUr6_a9IXgQfs000Kr7NB5i0000Ks0360RkJiLqPABYt52__rYd5gjVPUrsTmIEJEwCIUNYqJsv_LwsT__kJiLqPABzoQjVPUrsTpEKuAV&bd_vid=10261885814604727062\n" +
            "https://aisite.wejianzhan.com/site/wjzravwx/fe55a8b8-cb32-4182-a764-0fff8ceceb62?fid=P1TdnjTLrjc3rHb1PWDdnjfsn-tznWFxnf&ch=4&bfid=fbuFw0cK6BqYDnGQbA_00P300fZEIf3aZAyOQfs000avfRa5i0000Ks0360yEPXO8VHdseHy1_ZAdSllsegDVevLJaUy1o1gEeJdkQj_Vl6OYo83q_Wjkr5i3_Oz_o8dEUgD8_rLJPxHcmjCusY\n" +
            "https://aisite.wejianzhan.com/site/wjzzlkix/8c9afab3-ebda-4100-8534-8aee71b17d0b?fid=nH0vP1nYnjfdrHcLP1c3PWR1nWPxnWczg1c&ch=4&bfid=fbuFw0cK2qYORrvnZ4f00P3006Ap8fRa0DHZFfs000j6zmCmi0000Ks04s0cdn2SoU2eVxT8s5vtvU2edxv1Cz1PCelV_IySoi1AGQxYVl2ekWSq1nHWYoENYa1wSQ5v8_5FJOMpUP3&bd_vid=nH0vP1nYnjfdrHcLP1c3PWR1nWPxnWczg1FxnH0s\n" +
            "https://aisite.wejianzhan.com/site/wjzffbtw/02525b71-2c8e-4dee-be8a-de7f1b6fe355?fid=rHbdnHf1njR3nHR3njDvPWfkPdtznWFxnf&ch=4&bfid=fbuFw0cKDgRQ-hrNACC00P300fZOxxtKKk1JFss0000c7T3qi0000Ks0400Nd_zYoegDdJQgVQZV1qUHYnHDY2bOrPUnV2SdkPpBdeivEP5fknHfJIpBdefOYt5N3oWvVevLJaLy1QiE8_5Kz1ON4_oZ128sqnZQ51tO4l2uws&renqun_youhua=2958024\n" +
            "https://aisite.wejianzhan.com/site/wjz82h2w/49fa183c-dfcb-44cf-8bcd-77af39beddc4?dynType=2&dynId=dyn.0_exp.1&fid=nHDvnj0znWbvPjT3PHR4P16LPW7xnWczg1c&ch=4&bfid=fbuFw0cKaf-GTyIQO2000P30067x-53KAsBEEs_000jvGO0sff000Ks04002d_zYoegDdJQgVKLy1QiEz_xRqTrYYxhdkPpBdef9QIUnd5gjVQj_5dJ3ESD\n" +
            "https://aisite.wejianzhan.com/site/wjzwv5kx/e05402e2-5f92-4f8e-9730-13409595326f?fid=rj04PWR4rj0dn1f3njD4nW0kPNtznW9xnf&ch=4&bfid=fbuFw0cKjdWrn6W-gZ000rf00fZQSfmaYOJ8A0s000jIJD7bws000Ks0360f_thvEPUfVTQFqo29YoLR891FqVH6EQ2zCIgB85pLEUXCkPzsv_LwYPHrL_HTHfXye6\n" +
            "https://aisite.wejianzhan.com/site/wjz0d96x/ca07fcfc-6b93-4ff8-a4db-64da316e4eea?fid=rjcknH6znjnvnjmLPjnYP16krNtznWFxnf&ch=4&bfid=fbuFw0cK23VfFwsOqMD00P300f70VsbaDKhjjfs000j5f2e7w6000Ks0360fVtlzEq5fEXAqvV2JExHatjAL1_M5YqjfCUxr_oS1q_OyEXAqvVHdseisePQqkEadkjON3oWvVevLJnBLzoyOzIQRBVZLff";

    static String test = "online_url\n" +
            "https://qianhu.wejianzhan.com/site/wjzc3lkx/70562446-b68d-42fa-9f28-736b3aea6dca\n" +
            "https://aisite.wejianzhan.com/site/wjz3morx/cbce1512-71b1-412b-9d5b-7ac63797b5e5\n" +
            "https://aisite.wejianzhan.com/site/wjz9dhnw/2af263f9-9240-4d22-939b-0d4e0dcce543\n" +
            "https://aisite.wejianzhan.com/site/wjzqyj6w/762ecc2c-0489-4aec-8731-e69f9a36a1e5\n" +
            "https://aisite.wejianzhan.com/site/wjz91dwx/26de49b4-7c45-4d8f-9f82-a3563a5c84b4\n" +
            "https://qianhu.wejianzhan.com/site/wjzwjndx/cd3db109-023b-4059-ac67-1b7ff49fc33d\n" +
            "https://aisite.wejianzhan.com/site/wjzffbtw/02525b71-2c8e-4dee-be8a-de7f1b6fe355\n" +
            "https://aisite.wejianzhan.com/site/dl4.hqyt.com/22cef95a-c9fb-4363-97c6-c90e11042370\n" +
            "https://aisite.wejianzhan.com/site/wjzov5kx/8f0f5ef0-06ca-4951-a672-63f79e094630\n" +
            "https://aisite.wejianzhan.com/site/wjzo1p0w/2cbd10b8-af94-4edd-be7b-772048f5e839\n" +
            "https://aisite.wejianzhan.com/site/wjzj1dwx/71150e8c-ddd4-435e-847a-a3bfba08e3d8\n" +
            "https://aisite.wejianzhan.com/site/wjzravwx/fe55a8b8-cb32-4182-a764-0fff8ceceb62\n" +
            "https://aisite.wejianzhan.com/site/wjz01cbx/e614c348-5676-465b-ab8b-5a2d339cdd9b\n" +
            "https://aisite.wejianzhan.com/site/wjzwv5kx/e05402e2-5f92-4f8e-9730-13409595326f\n" +
            "https://aisite.wejianzhan.com/site/wjzoa84v/e585a3c9-8356-4fb8-baf6-bf27ccc429f5\n" +
            "https://aisite.wejianzhan.com/site/wjzlqfwx/a0950fe0-b0b8-4ead-9107-f901af57d08a\n" +
            "https://aisite.wejianzhan.com/site/wjzl1p0w/588dae97-c699-473e-b340-a86c76aa6717\n" +
            "https://aisite.wejianzhan.com/site/wjzp1p0w/4d24f2c3-db9c-4e54-b516-55fa4bf105e0\n" +
            "https://aisite.wejianzhan.com/site/wjzcedwx/6b48f90c-8f67-4227-ae0f-52737708f718\n" +
            "https://aisite.wejianzhan.com/site/wjzllkix/d0f4f291-4542-4a72-9bae-4adfcdd8a2da\n" +
            "https://aisite.wejianzhan.com/site/wjz8kfwx/895a74ec-3201-4e5a-a6d8-f987ab930468\n" +
            "https://aisite.wejianzhan.com/site/wjzcedwx/4cf43e0a-471b-4055-8111-b35d1eee43cf\n" +
            "https://aisite.wejianzhan.com/site/wjzbkwox/c41b1106-4751-4aa9-9b68-bc24cf3da971\n" +
            "https://aisite.wejianzhan.com/site/wjzg6gsx/c4bc2e82-2186-460f-9192-95e2f50979be\n" +
            "https://aisite.wejianzhan.com/site/wjzy0p0w/2e8c623c-c1fe-4ba6-b103-e0d3cc9df12e\n" +
            "https://aisite.wejianzhan.com/site/wjz2chnw/d2effc25-bf0f-4e18-8525-f54234bf057b\n" +
            "https://aisite.wejianzhan.com/site/wjz0d96x/ca07fcfc-6b93-4ff8-a4db-64da316e4eea\n" +
            "https://aisite.wejianzhan.com/site/wjzsv5kx/ac7790cb-6999-4ad4-aae2-629ff7424226\n" +
            "https://aisite.wejianzhan.com/site/wjzed6sx/3d9073c8-2de9-42bd-a2bf-8ef85eba5b12\n" +
            "https://aisite.wejianzhan.com/site/wjz06nbx/63a436f7-4f7c-4cf8-ba25-1b6cafea2215\n" +
            "https://aisite.wejianzhan.com/site/wjza9iew/419b3c9a-aa04-4679-8f04-c14d020d311b\n" +
            "https://aisite.wejianzhan.com/site/wjz7q8cx/1e6e97ff-11c8-420b-a3db-156f8989cd14\n" +
            "https://isite.baidu.com/site/wjzvztqx/ba9bf601-eaf5-4de8-a235-695997d9644b\n" +
            "https://qianhu.wejianzhan.com/site/wjzkdvmx/b6db3186-cd33-413c-ad86-bdd7e1ef3d25\n" +
            "https://aisite.wejianzhan.com/site/wjzzlkix/8c9afab3-ebda-4100-8534-8aee71b17d0b\n" +
            "https://aisite.wejianzhan.com/site/wjzumtzx/f9659ed4-caaf-4797-9974-ace595186127\n" +
            "https://aisite.wejianzhan.com/site/wjz82h2w/49fa183c-dfcb-44cf-8bcd-77af39beddc4\n" +
            "https://qianhu.wejianzhan.com/site/wjz88q5w/51efa277-dd66-4e23-9e43-e60369f2368a\n" +
            "https://aisite.wejianzhan.com/site/wjz35bwx/277c26d2-acbc-49ea-9099-0f1d7097052d\n" +
            "https://aisite.wejianzhan.com/site/wjz35bwx/5e8dc01c-a785-4381-9ae3-aab845310a6e\n" +
            "https://aisite.wejianzhan.com/site/wjzdyj6w/d91ca2b7-f81a-48ab-849b-7ebb149daaba";

    public static void main(String[] args) {

        String[] zhen = test.split("\n");

        List<String> zhenList = new ArrayList<>();
        for (int i = 0 ; i < zhen.length; i ++) {
            zhenList.add(zhen[i]);
        }
        String[] strings = string.split("\n");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < strings.length ; i ++) {
            String aa = strings[i].split("\\?")[0];
            int num = map.getOrDefault(aa, 0);
            if (num == 1) {
                System.out.println(aa);
            } else {
                map.put(aa, 1);
            }
        }
    }

}
