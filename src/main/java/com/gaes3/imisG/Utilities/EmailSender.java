package com.gaes3.imisG.Utilities;

import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.google.common.collect.Lists;



public class EmailSender {

	private static String BODY;

	public static boolean enviarEmail(List<String> lista , String asusto, String cuerpo) {

		String remitente = "horaciostiven.000@gmail.com";

		Properties props = System.getProperties();
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", "kgrbkpuauavvtzqn");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");
		BODY = String.join(System.getProperty("line.separator"),
				"<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n"
						+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\r\n"
						+ "<head>\r\n" + "<!--[if gte mso 9]>\r\n" + "<xml>\r\n" + "  <o:OfficeDocumentSettings>\r\n"
						+ "    <o:AllowPNG/>\r\n" + "    <o:PixelsPerInch>96</o:PixelsPerInch>\r\n"
						+ "  </o:OfficeDocumentSettings>\r\n" + "</xml>\r\n" + "<![endif]-->\r\n"
						+ "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n"
						+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "  <meta name=\"x-apple-disable-message-reformatting\">\r\n"
						+ "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\r\n"
						+ "  <title></title>\r\n" + "  \r\n" + "    <style type=\"text/css\">\r\n"
						+ "      @media only screen and (min-width: 620px) {\r\n" + "  .u-row {\r\n"
						+ "    width: 600px !important;\r\n" + "  }\r\n" + "  .u-row .u-col {\r\n"
						+ "    vertical-align: top;\r\n" + "  }\r\n" + "\r\n" + "  .u-row .u-col-100 {\r\n"
						+ "    width: 600px !important;\r\n" + "  }\r\n" + "\r\n" + "}\r\n" + "\r\n"
						+ "@media (max-width: 620px) {\r\n" + "  .u-row-container {\r\n"
						+ "    max-width: 100% !important;\r\n" + "    padding-left: 0px !important;\r\n"
						+ "    padding-right: 0px !important;\r\n" + "  }\r\n" + "  .u-row .u-col {\r\n"
						+ "    min-width: 320px !important;\r\n" + "    max-width: 100% !important;\r\n"
						+ "    display: block !important;\r\n" + "  }\r\n" + "  .u-row {\r\n"
						+ "    width: calc(100% - 40px) !important;\r\n" + "  }\r\n" + "  .u-col {\r\n"
						+ "    width: 100% !important;\r\n" + "  }\r\n" + "  .u-col > div {\r\n"
						+ "    margin: 0 auto;\r\n" + "  }\r\n" + "}\r\n" + "body {\r\n" + "  margin: 0;\r\n"
						+ "  padding: 0;\r\n" + "}\r\n" + "\r\n" + "table,\r\n" + "tr,\r\n" + "td {\r\n"
						+ "  vertical-align: top;\r\n" + "  border-collapse: collapse;\r\n" + "}\r\n" + "\r\n"
						+ "p {\r\n" + "  margin: 0;\r\n" + "}\r\n" + "\r\n" + ".ie-container table,\r\n"
						+ ".mso-container table {\r\n" + "  table-layout: fixed;\r\n" + "}\r\n" + "\r\n" + "* {\r\n"
						+ "  line-height: inherit;\r\n" + "}\r\n" + "\r\n" + "a[x-apple-data-detectors='true'] {\r\n"
						+ "  color: inherit !important;\r\n" + "  text-decoration: none !important;\r\n" + "}\r\n"
						+ "\r\n"
						+ "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } #u_content_heading_1 a { color: #000000; text-decoration: none; } @media (max-width: 480px) { #u_content_heading_1 .v-font-size { font-size: 26px !important; } #u_content_text_4 .v-container-padding-padding { padding: 0px 10px 40px !important; } #u_content_text_4 .v-line-height { line-height: 170% !important; } #u_content_button_1 .v-size-width { width: 60% !important; } #u_content_text_3 .v-container-padding-padding { padding: 0px 20px 20px !important; } #u_content_text_2 .v-container-padding-padding { padding: 0px 10px 80px !important; } #u_content_image_2 .v-src-width { width: auto !important; } #u_content_image_2 .v-src-max-width { max-width: 0% !important; } }\r\n"
						+ "    </style>\r\n" + "  \r\n" + "  \r\n" + "\r\n"
						+ "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\r\n"
						+ "\r\n" + "</head>\r\n" + "\r\n"
						+ "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #ffffff;color: #000000\">\r\n"
						+ "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\r\n"
						+ "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\r\n"
						+ "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #ffffff;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
						+ "  <tbody>\r\n" + "  <tr style=\"vertical-align: top\">\r\n"
						+ "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
						+ "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #ffffff;\"><![endif]-->\r\n"
						+ "    \r\n" + "\r\n"
						+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #6c6cd0\">\r\n"
						+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\r\n"
						+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
						+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #6c6cd0;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\r\n"
						+ "      \r\n"
						+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\r\n"
						+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
						+ "  <div style=\"height: 100%;width: 100% !important;\">\r\n"
						+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\r\n"
						+ "  \r\n"
						+ "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n" + "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
						+ "  <tr>\r\n" + "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\r\n"
						+ "      \r\n"
						+ "      <img align=\"center\" border=\"0\" src=\"images/image-6.png\" alt=\"\" title=\"\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 43%;max-width: 258px;\" width=\"258\" class=\"v-src-width v-src-max-width\"/>\r\n"
						+ "      \r\n" + "    </td>\r\n" + "  </tr>\r\n" + "</table>\r\n" + "\r\n" + "      </td>\r\n"
						+ "    </tr>\r\n" + "  </tbody>\r\n" + "</table>\r\n" + "\r\n"
						+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + "  </div>\r\n" + "</div>\r\n"
						+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
						+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + "    </div>\r\n"
						+ "  </div>\r\n" + "</div>\r\n" + "\r\n" + "\r\n" + "\r\n"
						+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #e9e9f3\">\r\n"
						+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\r\n"
						+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
						+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #e9e9f3;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\r\n"
						+ "      \r\n"
						+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #e9e9f3;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\r\n"
						+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
						+ "  <div style=\"background-color: #e9e9f3;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\r\n"
						+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\r\n"
						+ "  \r\n"
						+ "<table id=\"u_content_heading_1\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:80px 10px 0px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n"
						+ "  <h1 class=\"v-line-height v-font-size\" style=\"margin: 0px; line-height: 140%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Open Sans',sans-serif; font-size: 30px;\">\r\n"
						+ "    <div>\r\n" + "<div>\r\n" + "<div>\r\n" + "<div>\r\n" + "<div>\r\n"
						+ "<div><strong><a rel=\"noopener\" href=\"mailto:BIENVENID@S\" target=\"_blank\">BIENVENID@S</a> A IMIS</strong></div>\r\n"
						+ "</div>\r\n" + "</div>\r\n" + "</div>\r\n" + "</div>\r\n" + "</div>\r\n" + "  </h1>\r\n"
						+ "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n" + "</table>\r\n" + "\r\n"
						+ "<table id=\"u_content_text_4\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 50px 40px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n"
						+ "  <div class=\"v-line-height\" style=\"line-height: 160%; text-align: center; word-wrap: break-word;\">\r\n"
						+ "    <p style=\"font-size: 14px; line-height: 160%;\">Vimos que estuviste tratando de contactarte con nosotros, nuestro equipo de desarrolladores se pondrá en contacto lo mas pronto posible contigo para atender tus solicitudes.</p>\r\n"
						+ "  </div>\r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
						+ "</table>\r\n" + "\r\n"
						+ "<table id=\"u_content_button_1\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 10px 40px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n" + "<div align=\"center\">\r\n"
						+ "  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;font-family:'Montserrat',sans-serif;\"><tr><td style=\"font-family:'Montserrat',sans-serif;\" align=\"center\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"http://localhost:8080/imisG/\" style=\"height:37px; v-text-anchor:middle; width:203px;\" arcsize=\"67.5%\" stroke=\"f\" fillcolor=\"#da5345\"><w:anchorlock/><center style=\"color:#FFFFFF;font-family:'Montserrat',sans-serif;\"><![endif]-->\r\n"
						+ "    <a href=\"http://localhost:8080/imisG/\" target=\"_blank\" class=\"v-size-width\" style=\"box-sizing: border-box;display: inline-block;font-family:'Montserrat',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #FFFFFF; background-color: #da5345; border-radius: 25px;-webkit-border-radius: 25px; -moz-border-radius: 25px; width:35%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;\">\r\n"
						+ "      <span class=\"v-line-height\" style=\"display:block;padding:10px 20px;line-height:120%;\"><p style=\"font-size: 14px; line-height: 120%;\">Pagina principal</p></span>\r\n"
						+ "    </a>\r\n" + "  <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\r\n"
						+ "</div>\r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
						+ "</table>\r\n" + "\r\n"
						+ "<table id=\"u_content_text_3\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 60px 20px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n"
						+ "  <div class=\"v-line-height\" style=\"line-height: 140%; text-align: center; word-wrap: break-word;\">\r\n"
						+ "    <p style=\"font-size: 14px; line-height: 140%;\"><span style=\"font-size: 18px; line-height: 25.2px; font-family: 'Open Sans', sans-serif;\"><strong>Gracias por preferirnos :)</strong></span></p>\r\n"
						+ "  </div>\r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
						+ "</table>\r\n" + "\r\n"
						+ "<table id=\"u_content_text_2\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px 50px 80px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n"
						+ "  <div class=\"v-line-height\" style=\"line-height: 160%; text-align: center; word-wrap: break-word;\">\r\n"
						+ "    <p style=\"font-size: 14px; line-height: 160%;\">Si no tienes conocimiento de este mensaje has caso omiso.</p>\r\n"
						+ "    <p style=\"font-size: 14px; line-height: 160%;\">No responder a este automensaje.</p>\r\n"
						+ "<p style=\"font-size: 14px; line-height: 160%;\"> </p>\r\n"
						+ "<p style=\"font-size: 14px; line-height: 160%;\"> </p>\r\n" + "  </div>\r\n" + "\r\n"
						+ "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n" + "</table>\r\n" + "\r\n"
						+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + "  </div>\r\n" + "</div>\r\n"
						+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
						+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + "    </div>\r\n"
						+ "  </div>\r\n" + "</div>\r\n" + "\r\n" + "\r\n" + "\r\n"
						+ "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\r\n"
						+ "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\r\n"
						+ "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\r\n"
						+ "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\r\n"
						+ "      \r\n"
						+ "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\r\n"
						+ "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\r\n"
						+ "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\r\n"
						+ "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\r\n"
						+ "  \r\n"
						+ "<table id=\"u_content_image_2\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:80px 0px 10px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n" + "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n"
						+ "  <tr>\r\n" + "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\r\n"
						+ "      \r\n"
						+ "      <img align=\"center\" border=\"0\" src=\"images/image-5.png\" alt=\"Logo\" title=\"Logo\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 0%;max-width: 0px;\" class=\"v-src-width v-src-max-width\"/>\r\n"
						+ "      \r\n" + "    </td>\r\n" + "  </tr>\r\n" + "</table>\r\n" + "\r\n" + "      </td>\r\n"
						+ "    </tr>\r\n" + "  </tbody>\r\n" + "</table>\r\n" + "\r\n"
						+ "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n" + "<div align=\"center\">\r\n"
						+ "  <div style=\"display: table; max-width:187px;\">\r\n"
						+ "  <!--[if (mso)|(IE)]><table width=\"187\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:187px;\"><tr><![endif]-->\r\n"
						+ "  \r\n" + "    \r\n"
						+ "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\r\n"
						+ "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\r\n"
						+ "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
						+ "        <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\r\n"
						+ "          <img src=\"images/image-1.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
						+ "        </a>\r\n" + "      </td></tr>\r\n" + "    </tbody></table>\r\n"
						+ "    <!--[if (mso)|(IE)]></td><![endif]-->\r\n" + "    \r\n"
						+ "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\r\n"
						+ "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\r\n"
						+ "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
						+ "        <a href=\"https://twitter.com/\" title=\"Twitter\" target=\"_blank\">\r\n"
						+ "          <img src=\"images/image-3.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
						+ "        </a>\r\n" + "      </td></tr>\r\n" + "    </tbody></table>\r\n"
						+ "    <!--[if (mso)|(IE)]></td><![endif]-->\r\n" + "    \r\n"
						+ "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\r\n"
						+ "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\r\n"
						+ "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
						+ "        <a href=\"https://linkedin.com/\" title=\"LinkedIn\" target=\"_blank\">\r\n"
						+ "          <img src=\"images/image-2.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
						+ "        </a>\r\n" + "      </td></tr>\r\n" + "    </tbody></table>\r\n"
						+ "    <!--[if (mso)|(IE)]></td><![endif]-->\r\n" + "    \r\n"
						+ "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\r\n"
						+ "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\r\n"
						+ "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\r\n"
						+ "        <a href=\"https://instagram.com/\" title=\"Instagram\" target=\"_blank\">\r\n"
						+ "          <img src=\"images/image-4.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\r\n"
						+ "        </a>\r\n" + "      </td></tr>\r\n" + "    </tbody></table>\r\n"
						+ "    <!--[if (mso)|(IE)]></td><![endif]-->\r\n" + "    \r\n" + "    \r\n"
						+ "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + "  </div>\r\n"
						+ "</div>\r\n" + "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n"
						+ "</table>\r\n" + "\r\n"
						+ "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\r\n"
						+ "  <tbody>\r\n" + "    <tr>\r\n"
						+ "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 80px;font-family:'Montserrat',sans-serif;\" align=\"left\">\r\n"
						+ "        \r\n"
						+ "  <div class=\"v-line-height\" style=\"line-height: 160%; text-align: center; word-wrap: break-word;\">\r\n"
						+ "    <p style=\"font-size: 14px; line-height: 160%;\">GAES 2 </p>\r\n"
						+ "<p style=\"font-size: 14px; line-height: 160%;\"> </p>\r\n"
						+ "<p style=\"font-size: 14px; line-height: 160%;\">2022 - IMIS</p>\r\n" + "  </div>\r\n"
						+ "\r\n" + "      </td>\r\n" + "    </tr>\r\n" + "  </tbody>\r\n" + "</table>\r\n" + "\r\n"
						+ "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\r\n" + "  </div>\r\n" + "</div>\r\n"
						+ "<!--[if (mso)|(IE)]></td><![endif]-->\r\n"
						+ "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\r\n" + "    </div>\r\n"
						+ "  </div>\r\n" + "</div>\r\n" + "\r\n" + "\r\n"
						+ "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + "    </td>\r\n" + "  </tr>\r\n"
						+ "  </tbody>\r\n" + "  </table>\r\n" + "  <!--[if mso]></div><![endif]-->\r\n"
						+ "  <!--[if IE]></div><![endif]-->\r\n" + "</body>\r\n" + "\r\n" + "</html>\r\n" + "");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(remitente));
			Address[] correo = getAddresses(lista);
			message.addRecipients(Message.RecipientType.TO,correo);
			message.setSubject(asusto);
			message.setContent(BODY, "text/html");

			Transport transport = session.getTransport("smtp");
			String clave = "kgrbkpuauavvtzqn";
			transport.connect("smtp.gmail.com", remitente, clave);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			return true;

		} catch (MessagingException me) {
			me.printStackTrace();
			System.out.println("Hola" + me.getMessage());
			return false;
		}

	}
	private static Address[] getAddresses(List<String> toList) {
		List<InternetAddress> addresses = Lists.newArrayListWithCapacity(toList.size());

		for (String to : toList) {
			try {
				addresses.add(new InternetAddress(to));
			} catch (AddressException t) {
				System.out.println(t.getMessage());
			}
		}

		return addresses.toArray(new InternetAddress[addresses.size()]);
	}

}
