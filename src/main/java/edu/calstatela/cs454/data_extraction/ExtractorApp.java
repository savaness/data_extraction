package edu.calstatela.cs454.data_extraction;

/**
 * http://www.java2s.com/Tutorial/Java/0320__Network/Getallhyperlinksfromawebpage.htm
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtractorApp {

	public static void main(String args[]) {

		// Initialize Crawler & Extractor
		Extractor extr = new Extractor();
		Storage saving = new Storage();
		Set<CrawledLink> visitedLinks = null;
		try {
			visitedLinks = saving.readJSON(args[0]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(visitedLinks.size());
		List<CrawledLink> test = new ArrayList<CrawledLink>(visitedLinks);
		
		for(int i = 0; i < test.size(); i++){
			try {
				System.out.println("Link No: " + i + "  Link Local: " + test.get(i).getLocalPath());
				Map<String, String> metadata = extr.extractMeta(test.get(i).getLocalPath());
				test.get(i).setMetadata(metadata);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			List<Link> links = new ArrayList<Link> (test.get(i).getListOfLinks());
//			System.out.println("Link No: " + i + "  -- Link: " + links.size());
		}
		
		saving.store2(test);
		
		

//		// INITIAL CRAWL
//
//		try {
//			currentLinkMap = crawler.crawl(currentURL);
//			links = currentLinkMap.get("images");
//			links2 = currentLinkMap.get("files");
//			links3 = currentLinkMap.get("links");
//			linksQueue.addAll(links3);
//			countNextDepth = links3.size();
//
//			System.out.println("--------------" + countNextDepth
//					+ "--------------");
//
//			depth++;
//
//			for (String link : links) {
//				String fileDir = extr.downloadFiles(link);
//				fileMap.put(link, fileDir);
//			}
//
//			for (String link : links2) {
//				String fileDir = extr.downloadFiles(link);
//				fileMap.put(link, fileDir);
//			}
//			
//			for (String link : links3) {
//				String fileDir = extr.downloadFiles(link);
//				fileMap.put(link, fileDir);
//			}
//
//			visitedLinks.add(currentURL);
//			linkMap.put(currentURL, extr.parseExample(currentURL));
//			saving.store2(linkMap);
//
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
//
//		// CRAWL LOOP
//
//		while (!linksQueue.isEmpty() && depth <= maxDepth) {
//
//			System.out
//					.println("--------------ENTERING CRAWL LOOP--------------");
//			System.out.println("--------------LINKS QUEUE SIZE: "
//					+ linksQueue.size());
//
//
//			while (countNextDepth > 0 && visitedLinks.size() < 10) {
//				currentURL = linksQueue.remove();
//				
//				System.out.println("--------------VISITED LINKS SIZE: "
//						+ visitedLinks.size());
//
//				if (!visitedLinks.contains(currentURL)) {
//					System.out.println("--------------NEXT URL: " + currentURL
//							+ "--------------");
//					System.out
//							.println("--------------PASSED TEST--------------");
//					try {
//						currentLinkMap = crawler.crawl(currentURL);
//						links = currentLinkMap.get("images");
//						links2 = currentLinkMap.get("files");
//						links3 = currentLinkMap.get("links");
//						linksQueue.addAll(links3);
//						countNextDepth--;
//						countCurrDepth += links3.size();
//						System.out.println("--------------COUNT CURR DEPTH: "
//								+ countCurrDepth + "--------------");
//						System.out.println("--------------COUNT NEXT DEPTH: "
//								+ countNextDepth + "--------------");
//						
//						for (String link : links3) {
//							String fileDir = extr.downloadFiles(link);
//							fileMap.put(link, fileDir);
//						}
//						
//						for (String link : links) {
//							String fileDir = extr.downloadFiles(link);
//							fileMap.put(link, fileDir);
//						}
//
//						for (String link : links2) {
//							String fileDir = extr.downloadFiles(link);
//							fileMap.put(link, fileDir);
//						}
//					
//						
//						visitedLinks.add(currentURL);
//						linkMap.put(currentURL, extr.parseExample(currentURL));
//						saving.store2(linkMap);
//					} catch (Exception e1) {
//						e1.printStackTrace();
//					}
//
//				}
//			}
//
//			System.out.println("--------------I'M WORKING!!!!--------------");
//			countNextDepth = countCurrDepth;
//			depth++;
//
//		}
//
//		Iterator<Entry<String, String>> it = fileMap.entrySet().iterator();
//		while (it.hasNext()) {
//			@SuppressWarnings("rawtypes")
//			Map.Entry pair = (Map.Entry) it.next();
//			System.out.println(pair.getKey() + " = " + pair.getValue());
//			try {
//				linkMap.put((String) pair.getValue(),
//						extr.extractMeta((String) pair.getValue()));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("--------------------");
//			saving.store2(linkMap);
//			it.remove();
//		}
//
//		System.out.println("LINK MAP SIZE: " + linkMap.size());
//
//		// storage
//
//		saving.store2(linkMap);

	}

}