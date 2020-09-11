package com.josh.web;

import java.io.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "textAdd", urlPatterns = "/page-hub/add-text")
public class AddTextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        FileWriter fw = new FileWriter("C:/Users/joshr/vs_code_workspace/Firewall/TextHistory.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw, true);
        String text = req.getParameter("text");

        System.out.println(text);
        pw.println(text);
        pw.close();

        /* try {
            ChannelSftp channel = setupJsch();
            channel.connect();
            String localDir = "C:/Users/joshr/vs_code_workspace/Firewall/TextHistory.csv";
            String remoteDir = "/home/ubuntu";
            channel.put(localDir, remoteDir + "text.csv");
            channel.exit();

        } catch (JSchException e) {
            System.err.println("Could not set up channel to remote file" + e);
        } catch (SftpException e) {
            System.err.println("Problem adding file");
        } */

        resp.sendRedirect("/page-hub/page02");
    }

    /* private ChannelSftp setupJsch() throws JSchException {
        JSch jsch = new JSch();
        jsch.addIdentity("C:/Users/joshr/josh_aws_revature.pem");
        Session jschSession = jsch.getSession("ubuntu", "ec2-3-134-94-233.us-east-2.compute.amazonaws.com/", 22);
        return (ChannelSftp) jschSession.openChannel("sftp");
    } */

    @Override
    public void destroy() {
        super.destroy();
    }
}
