package com.iktpreobuka.t4.services;

import com.iktpreobuka.t4.dto.EmailObject;

public interface EmailService {

	void sendSimpleMessage(EmailObject object);

	void sendTemplateMessage(EmailObject object) throws Exception;

	void sendMessageWithAttachment(EmailObject object, String pathToAttachment) throws Exception;
}
