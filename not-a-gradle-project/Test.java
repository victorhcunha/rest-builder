import com.liferay.headless.delivery.client.dto.v1_0.KnowledgeBaseFolder;
import com.liferay.headless.delivery.client.resource.v1_0.KnowledgeBaseFolderResource;

import com.liferay.headless.delivery.client.dto.v1_0.KnowledgeBaseArticle;
import com.liferay.headless.delivery.client.resource.v1_0.KnowledgeBaseArticleResource;

import com.liferay.headless.delivery.client.dto.v1_0.DocumentFolder;
import com.liferay.headless.delivery.client.resource.v1_0.DocumentFolderResource;

import com.liferay.headless.delivery.client.dto.v1_0.Document;
import com.liferay.headless.delivery.client.resource.v1_0.DocumentResource;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class Test {
	public static void main(String[] args) throws Exception {

		Long siteId = 20121L;

		// KnowledgeBaseFolder
		// builder
		KnowledgeBaseFolderResource.Builder knowledgeBaseFolderResourceBuilder = KnowledgeBaseFolderResource.builder();
		KnowledgeBaseFolderResource kbfResource = knowledgeBaseFolderResourceBuilder.authentication(
				"test@liferay.com", "teste").build();

		// post-create
		KnowledgeBaseFolder kbFolder1 = new KnowledgeBaseFolder();
		kbFolder1.setDescription("kbFolder1 Description");
		kbFolder1.setName("kbFolder1");

		kbFolder1 = kbfResource.postSiteKnowledgeBaseFolder(siteId, kbFolder1);

		// get-read
		System.out.println(kbfResource.getKnowledgeBaseFolder(kbFolder1.getId()));

		// put-update
		kbFolder1.setDescription("New Description");
		kbFolder1.setName("New Name kbFolder1");

		kbFolder1 = kbfResource.putKnowledgeBaseFolder(kbFolder1.getId(), kbFolder1);

		// delete-delete
		kbfResource.deleteKnowledgeBaseFolder(kbFolder1.getId());

		// KnowledgeBaseArticle
		// builder
		KnowledgeBaseArticleResource.Builder knowledgeBaseArticleBuilder = KnowledgeBaseArticleResource.builder();
		KnowledgeBaseArticleResource kbaResource = knowledgeBaseArticleBuilder.authentication(
				"test@liferay.com", "teste").build();

		// post-create
		KnowledgeBaseArticle kbArticle1 = new KnowledgeBaseArticle();
		kbArticle1.setArticleBody("Body 1");
		kbArticle1.setDescription("Description 1");
		kbArticle1.setTitle("Article 1");

		kbArticle1 = kbaResource.postSiteKnowledgeBaseArticle(siteId, kbArticle1);

		// get-read
		System.out.println(kbaResource.getKnowledgeBaseArticle(kbArticle1.getId()));

		// put-update
		kbArticle1.setArticleBody("New Body");
		kbArticle1.setDescription("New Description");

		kbArticle1 = kbaResource.putKnowledgeBaseArticle(kbArticle1.getId(),
				kbArticle1);

		// delete-delete
		kbaResource.deleteKnowledgeBaseArticle(kbArticle1.getId());

		// DocumentFolder
		// builder
		DocumentFolderResource.Builder documentFolderResourceBuilder = DocumentFolderResource.builder();
		DocumentFolderResource dfResource = documentFolderResourceBuilder.authentication(
				"test@liferay.com", "teste").build();

		// post-create
		DocumentFolder dFolder1 = new DocumentFolder();
		dFolder1.setDescription("dFolder1 Description");
		dFolder1.setName("dFolder1");

		dFolder1 = dfResource.postSiteDocumentFolder(siteId, dFolder1);

		// get-read
		System.out.println(dfResource.getDocumentFolder(dFolder1.getId()));

		// put-update
		dFolder1.setDescription("New Description");
		dFolder1.setName("New Name dFolder1");

		dFolder1 = dfResource.putDocumentFolder(dFolder1.getId(), dFolder1);

		// delete-delete
		dfResource.deleteDocumentFolder(dFolder1.getId());

		// Document
		// builder
		DocumentResource.Builder documentBuilder = DocumentResource.builder();

		DocumentResource dResource = documentBuilder.authentication(
				"test@liferay.com", "teste").build();

		// post-create
		Document document1 = new Document();
		document1.setTitle("JohnOwen");
		document1.setDescription("document1 Description");

		File file = new File("JohnOwen.jpg");
		Map<String, File> files = new HashMap<String, File>();
		files.put("file", file);

		document1 = dResource.postSiteDocument(20121L, document1, files);

		// get-read
		System.out.println(dResource.getDocument(document1.getId()));

		// put-update
		document1.setDescription("New Description");
		document1.setTitle("New Name document1");

		document1 = dResource.putDocument(document1.getId(), document1, files);

		// delete-delete
		dResource.deleteDocument(document1.getId());

	}
}