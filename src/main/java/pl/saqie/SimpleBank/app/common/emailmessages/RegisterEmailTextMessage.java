package pl.saqie.SimpleBank.app.common.emailmessages;

public class RegisterEmailTextMessage {

    public static String getRegisterEmailText(String adress){
        return "<head><meta name=\"viewport\" content=\"width=device-width\"><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "\t<title>SendGrid Signup Confirmation</title>\n" +
                "\t<style media=\"all\" type=\"text/css\">@media only screen and (max-width: 480px) {\n" +
                "  table[class=body] h1 {\n" +
                "    font-size: 24px !important;\n" +
                "  }\n" +
                "  table[class=body] h2 {\n" +
                "    font-size: 20px !important;\n" +
                "  }\n" +
                "  table[class=body] h3 {\n" +
                "    font-size: 14px !important;\n" +
                "  }\n" +
                "  table[class=body] .content,\n" +
                "  table[class=body] .wrapper {\n" +
                "    padding: 15px !important;\n" +
                "  }\n" +
                "  table[class=body] .container {\n" +
                "    width: 100% !important;\n" +
                "    padding: 0 !important;\n" +
                "  }\n" +
                "  table[class=body] .column {\n" +
                "    width: 100% !important;\n" +
                "  }\n" +
                "  table[class=body] .stats .column {\n" +
                "    width: 50% !important;\n" +
                "  }\n" +
                "  table[class=body] .hero-image,\n" +
                "  table[class=body] .thumb {\n" +
                "    width: 100% !important;\n" +
                "    height: auto !important;\n" +
                "  }\n" +
                "  table[class=body] .btn table,\n" +
                "  table[class=body] .btn a {\n" +
                "    width: 100% !important;\n" +
                "  }\n" +
                "  table[class=body] .stats-table {\n" +
                "    display: none !important;\n" +
                "  }\n" +
                "  table[class=body] .stats-labels .label,\n" +
                "  table[class=body] .category-labels .label {\n" +
                "    font-size: 10px !important;\n" +
                "  }\n" +
                "  table[class=body] .credits table {\n" +
                "    table-layout: auto !important;\n" +
                "  }\n" +
                "  table[class=body] .credits .label {\n" +
                "    font-size: 11px !important;\n" +
                "  }\n" +
                "}\n" +
                "\t</style>\n" +
                "\t<style type=\"text/css\">@font-face {\n" +
                "    font-family: 'Open Sans';\n" +
                "    font-style: normal;\n" +
                "    font-weight: 300;\n" +
                "    src: local('Open Sans Light'), local('OpenSans-Light'), url(https://fonts.gstatic.com/s/opensans/v13/DXI1ORHCpsQm3Vp6mXoaTYnF5uFdDttMLvmWuJdhhgs.ttf) format('truetype');\n" +
                "}\n" +
                "\n" +
                "\n" +
                "@font-face {\n" +
                "    font-family: 'Open Sans';\n" +
                "    font-style: normal;\n" +
                "    font-weight: 400;\n" +
                "    src: local('Open Sans'), local('OpenSans'), url(https://fonts.gstatic.com/s/opensans/v13/cJZKeOuBrn4kERxqtaUH3aCWcynf_cDxXwCLxiixG1c.ttf) format('truetype');\n" +
                "}\n" +
                "\n" +
                "\n" +
                "@font-face {\n" +
                "    font-family: 'Open Sans';\n" +
                "    font-style: normal;\n" +
                "    font-weight: 600;\n" +
                "    src: local('Open Sans Semibold'), local('OpenSans-Semibold'), url(https://fonts.gstatic.com/s/opensans/v13/MTP_ySUJH_bn48VBG8sNSonF5uFdDttMLvmWuJdhhgs.ttf) format('truetype');\n" +
                "}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body style=\"font-size: 16px; background-color: #fdfdfd; margin: 0; padding: 0; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; -webkit-text-size-adjust: 100%; line-height: 1.5; -ms-text-size-adjust: 100%; -webkit-font-smoothing: antialiased; height: 100% !important; width: 100% !important;\">\n" +
                "<table bgcolor=\"#fdfdfd\" class=\"body\" style=\"box-sizing: border-box; border-spacing: 0; mso-table-rspace: 0pt; mso-table-lspace: 0pt; width: 100%; background-color: #fdfdfd; border-collapse: separate !important;\" width=\"100%\">\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td style=\"box-sizing: border-box; padding: 0; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-size: 16px; vertical-align: top;\" valign=\"top\">&nbsp;</td>\n" +
                "\t\t\t<td class=\"container\" style=\"box-sizing: border-box; padding: 0; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-size: 16px; vertical-align: top; display: block; width: 600px; max-width: 600px; margin: 0 auto !important;\" valign=\"top\" width=\"600\">\n" +
                "\t\t\t<div class=\"content\" style=\"box-sizing: border-box; display: block; max-width: 600px; margin: 0 auto; padding: 10px;\"><span class=\"preheader\" style=\"color: transparent; display: none; height: 0; max-height: 0; max-width: 0; opacity: 0; overflow: hidden; mso-hide: all; visibility: hidden; width: 0;\">Potwierdz adres E-Mail</span>\n" +
                "\t\t\t<div class=\"block\" style=\"box-sizing: border-box; width: 100%; margin-bottom: 30px; background: #ffffff; border: 1px solid #f0f0f0;\">\n" +
                "\t\t\t<table style=\"box-sizing: border-box; width: 100%; border-spacing: 0; mso-table-rspace: 0pt; mso-table-lspace: 0pt; border-collapse: separate !important;\" width=\"100%\">\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"wrapper\" style=\"box-sizing: border-box; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-size: 16px; vertical-align: top; padding: 30px;\" valign=\"top\">\n" +
                "\t\t\t\t\t\t<table style=\"box-sizing: border-box; width: 100%; border-spacing: 0; mso-table-rspace: 0pt; mso-table-lspace: 0pt; border-collapse: separate !important;\" width=\"100%\">\n" +
                "\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"box-sizing: border-box; padding: 0; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-size: 16px; vertical-align: top;\" valign=\"top\">\n" +
                "\t\t\t\t\t\t\t\t\t<h2 style=\"margin: 0; margin-bottom: 30px; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: 300; line-height: 1.5; font-size: 24px; color: #294661 !important;\">\n" +
                "\t\t\t\t\t\t\t\t\tPotwierdz swój adres E-Mail.</h2>\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t<p style=\"margin: 0; margin-bottom: 30px; color: #294661; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 300;\">Kliknij w poniższy link aby dokończyć rejestracje nowego konta bankowego.</p>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td style=\"box-sizing: border-box; padding: 0; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-size: 16px; vertical-align: top;\" valign=\"top\">\n" +
                "\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" class=\"btn btn-primary\" style=\"box-sizing: border-box; border-spacing: 0; mso-table-rspace: 0pt; mso-table-lspace: 0pt; width: 100%; border-collapse: separate !important;\" width=\"100%\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style=\"box-sizing: border-box; padding: 0; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-size: 16px; vertical-align: top; padding-bottom: 15px;\" valign=\"top\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" style=\"box-sizing: border-box; border-spacing: 0; mso-table-rspace: 0pt; mso-table-lspace: 0pt; width: auto; border-collapse: separate !important;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<a style=\"box-sizing: border-box; border-color: #348eda; font-weight: 400; text-decoration: none; display: inline-block; margin: 0; color: #ffffff; background-color: #348eda; border: solid 1px #348eda; border-radius: 2px; cursor: pointer; font-size: 14px; padding: 12px 45px; \"href=\"" + adress + "\">Potwierdz swój adres E-mail</a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</tbody>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\t\t\t<div class=\"footer\" style=\"box-sizing: border-box; clear: both; width: 100%;\">\n" +
                "\t\t\t<table style=\"box-sizing: border-box; width: 100%; border-spacing: 0; mso-table-rspace: 0pt; mso-table-lspace: 0pt; font-size: 12px; border-collapse: separate !important;\" width=\"100%\">\n" +
                "\t\t\t\t<tbody>\n" +
                "\t\t\t\t\t<tr style=\"font-size: 12px;\">\n" +
                "\t\t\t\t\t\t<td align=\"center\" class=\"align-center\" style=\"box-sizing: border-box; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; vertical-align: top; font-size: 12px; text-align: center; padding: 20px 0;\" valign=\"top\">\n" +
                "<p style=\"margin: 0; color: #294661; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: 300; font-size: 12px; margin-bottom: 5px;\">Created by SaQie github.com/SaQie</p>\n" +
                "\n" +
                "\t\t\t\t\t\t<p style=\"margin: 0; color: #294661; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-weight: 300; font-size: 12px; margin-bottom: 5px;\"> <a href=\"https://github.com/SaQie\" style=\"box-sizing: border-box; color: #348eda; font-weight: 400; text-decoration: none; font-size: 12px; padding: 0 5px;\" target=\"_blank\">GitHub</a><a href=\"https://www.linkedin.com/in/kamil-otyński-30245622a/\" style=\"box-sizing: border-box; color: #348eda; font-weight: 400; text-decoration: none; font-size: 12px; padding: 0 5px;\" target=\"_blank\">LinkedIn</a></p>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</tbody>\n" +
                "\t\t\t</table>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td style=\"box-sizing: border-box; padding: 0; font-family: 'Open Sans', 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif; font-size: 16px; vertical-align: top;\" valign=\"top\">&nbsp;</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "</body>";
    }

}
