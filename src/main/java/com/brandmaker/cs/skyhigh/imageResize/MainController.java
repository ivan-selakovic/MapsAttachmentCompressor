package com.brandmaker.cs.skyhigh.imageResize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brandmaker.cs.skyhigh.imageResize.service.ImageResize;

@Controller
public class MainController {

	@Autowired
	ImageResize imageResize;

	@GetMapping(value = "/status")
	@ResponseBody
	public String index() {
		String response = "Processed Nodes: " + imageResize.getProcessedNodes() + " out of: "
				+ imageResize.getTotalNodes();
		return response;
	}

	@GetMapping(value = "/runResize")
	@ResponseBody
	@Async
	public String runResize() throws Exception {
		imageResize.runResize();
		return "Mannual image resize running!";
	}

}
