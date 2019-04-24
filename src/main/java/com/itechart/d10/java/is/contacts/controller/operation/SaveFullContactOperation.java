package com.itechart.d10.java.is.contacts.controller.operation;

import com.itechart.d10.java.is.contacts.controller.api.ICommand;
import com.itechart.d10.java.is.contacts.dao.api.entity.IContact;
import com.itechart.d10.java.is.contacts.dao.api.entity.IPhone;
import com.itechart.d10.java.is.contacts.dao.api.enums.Gender;
import com.itechart.d10.java.is.contacts.dao.api.enums.MaritalStatus;
import com.itechart.d10.java.is.contacts.dao.api.enums.PhoneType;
import com.itechart.d10.java.is.contacts.dao.impl.entity.Phone;
import com.itechart.d10.java.is.contacts.service.IAttachmentService;
import com.itechart.d10.java.is.contacts.service.IContactService;
import com.itechart.d10.java.is.contacts.service.IPhoneService;
import com.itechart.d10.java.is.contacts.service.impl.AttachmentServiceImpl;
import com.itechart.d10.java.is.contacts.service.impl.ContactServiceImpl;
import com.itechart.d10.java.is.contacts.service.impl.PhoneServiceImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveFullContactOperation implements ICommand {

    private IContactService contactServiceImpl = new ContactServiceImpl();

    private IPhoneService phoneService = new PhoneServiceImpl();

    private IAttachmentService attachmentService = new AttachmentServiceImpl();

    private static final String UPLOAD_DIRECTORY = "upload";
    public static final String DEFAULT_FILENAME = "default.file";

    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;

    private static SaveFullContactOperation instance;

    private SaveFullContactOperation() {

    }

    public static SaveFullContactOperation getInstance() {
        if (instance == null) {
            instance = new SaveFullContactOperation();
        }
        return instance;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        IContact entity = null;
        request.setAttribute("contact", entity);
        if ("".equals(request.getParameter("contactId"))) {
            entity = contactServiceImpl.createEntity();
        } else {
            Integer contactId = Integer.parseInt(request.getParameter("contactId"));
            entity = contactServiceImpl.getById(contactId);
            entity.setId(contactId);
        }
        entity.setFirstName(request.getParameter("firstName"));
        entity.setMidleName(request.getParameter("midleName"));
        entity.setLastName(request.getParameter("lastName"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String bDay = request.getParameter("birthday");
        Date birthday = null;
        try {
            birthday = new Date(dateFormat.parse(bDay).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        entity.setBirthday(birthday);
        entity.setGender(Gender.valueOf(request.getParameter("gender")));
        entity.setCitizenship(request.getParameter("citizenship"));
        entity.setMaritalStatus(MaritalStatus.valueOf(request.getParameter("maritalStatus")));
        entity.setWebsite(request.getParameter("website"));
        entity.setEmail(request.getParameter("email"));
        entity.setCompany(request.getParameter("company"));
        entity.setCountry(request.getParameter("country"));
        entity.setCity(request.getParameter("city"));
        entity.setStreet(request.getParameter("street"));
        entity.setHouseNumber(request.getParameter("houseNumber"));
        entity.setApartment(Integer.parseInt(request.getParameter("apartment")));
        entity.setZip(request.getParameter("zip"));

        List<IPhone> phoneList = new ArrayList<IPhone>();

        if (request.getParameterValues("phoneId") != null) {
            String[] idPhoneList = request.getParameterValues("phoneId");

            for (int i = 0; i < idPhoneList.length; i++) {
                if (request.getParameter("phoneNumber" + idPhoneList[i]) != null) {
                    IPhone thePhone = new Phone();
                    thePhone.setContact(entity);
                    thePhone.setCountryCode(request.getParameter("countryCode" + idPhoneList[i]));
                    thePhone.setOperatorCode(request.getParameter("operatorCode" + idPhoneList[i]));
                    thePhone.setPhoneNumber(request.getParameter("phoneNumber" + idPhoneList[i]));
                    thePhone.setPhoneType(PhoneType.valueOf(request.getParameter("phoneType" + idPhoneList[i])));
                    thePhone.setComment(request.getParameter("phoneComment" + idPhoneList[i]));
                    phoneList.add(thePhone);
                }
            }
        }

//        List<IAttachment> attachmentList = new ArrayList<IAttachment>();
//
//        if (request.getParameterValues("fileId") != null) {
//
//            String[] idAttachList = request.getParameterValues("fileId");
//            for (int i = 0; i < idAttachList.length; i++) {
//                if (request.getParameter("fileName" + idAttachList[i]) != null) {
//                    IAttachment theAttach = new Attachment();
//                    theAttach.setContact(entity);
//                    theAttach.setFileName(request.getParameter("filename" + idAttachList[i]));
//                    theAttach.setComment(request.getParameter("fileComment" + idAttachList[i]));
//                    String filePath = uploadFile(request);
//                }
//            }
//        }

        contactServiceImpl.save(entity, phoneList);

        return "/controller?operation=LIST_CONTACT";
    }

//    private String uploadFile(HttpServletRequest request) {
//        if (ServletFileUpload.isMultipartContent(request)) {
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            factory.setSizeThreshold(MEMORY_THRESHOLD);
//            File tempDir = (File) request.getServletContext().getAttribute("javax.servlet.context.tempdir");
//            factory.setRepository(tempDir);
//
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            upload.setFileSizeMax(MAX_FILE_SIZE);
//            upload.setSizeMax(MAX_REQUEST_SIZE);
//            String uploadPath = request.getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
//            List<FileItem> formItems = null;
//            try {
//                formItems = upload.parseRequest(request);
//            } catch (FileUploadException ex) {
//            }
//            if (formItems != null && formItems.size() > 0) {
//                File uploadDir = new File(uploadPath);
//                if (!uploadDir.exists()) {
//                    uploadDir.mkdir();
//                }
//
//                for (FileItem item : formItems) {
//                    if (!item.isFormField()) {
//                        String fileName = new File(item.getName()).getName();
//                        String filePath = uploadPath + File.separator + fileName;
//                        File storeFile = new File(filePath);
//                        try {
//                            item.write(storeFile);
//                        } catch (Exception ex) {
//                            Logger.getLogger(AttachmentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//
//        }
//        return null;
//    }

}
