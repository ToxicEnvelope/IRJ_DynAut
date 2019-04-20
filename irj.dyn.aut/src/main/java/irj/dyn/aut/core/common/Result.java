package irj.dyn.aut.core.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the boolean result of some action along with a string for an error message.
 * This can be the default object to return when performing a transaction such as creating
 * a user account. The idea is that this object will be passed back to the test script
 * where an error can be properly handled from within a test.
 */
public class Result {
    private static final Logger logger = LoggerFactory.getLogger(Result.class);
    private boolean success;
    private List<String> messages;
    private List<String> errMessages;
    private Exception exception;

    /**
     * Constructor. Default success to false.
     */
    public Result() {
        success = false;
        messages = new ArrayList<>();
        errMessages = new ArrayList<>();
    }

    /**
     *
     * @return the state of the Result
     */
    public boolean isSuccess()
    {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Getting Success Value -> "+success);
        return success;
    }

    /**
     * Set the state of the Result
     * @param success
     */
    public void setSuccess(boolean success) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Setting success to -> "+ success);
        this.success = success;
    }

    /**
     * Returns the list of error messages
     * @return
     */
    public List<String> getMessages() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Getting All Messages -> "+messages);
        return messages;
    }

    /**
     * Returns the list of error messages
     * @return List of String Collection
     * @author - Yahav N. Hoffman
     */
    public List<String> getErrorMessages() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Getting All Error Messages -> "+errMessages);
        return errMessages;
    }
    /**
     * Adds an error message to the Result
     * @param msg
     */
    public void addMsg(String msg) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Add New Message -> "+msg);
        this.messages.add(msg);
    }

    /**
     * Adding a single Error Message to Collection
     * @param errMsg String object
     * @author - Yahav N. Hoffman
     */
    public void addErrMsg(String errMsg) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Add New Error Message -> "+ errMsg);
        this.errMessages.add(errMsg);
    }

    /**
     * Adding multiple Error Messages to Collection
     * @param errMsgs ArrayList of String Collection
     * @author - Yahav N. Hoffman
     */
    public void addErrMsgs(ArrayList<String> errMsgs) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Adding All Error Messages -> "+ errMsgs);
        this.errMessages.addAll(errMsgs);
    }

    /**
     * Add a list of error messages to the Result
     * @param messages
     */
    public void addMsgs(ArrayList<String> messages) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Adding All Messages -> "+ messages);
        this.messages.addAll(messages);
    }

    /**
     * Add an Exception to the Result object
     * @param e
     */
    public void addException(Exception e ) {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        logger.debug("Adding new Exception -> "+ e);
        exception = e;
    }

    /**
     * Print the list of error messages at ERROR level
     */
    public void printMessages() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        if(messages != null) {
            logger.debug("Printing out Error Messages");
            for (String message: messages) {
                logger.error(message);
            }
        }
        if(exception != null) {
            exception.printStackTrace();
        }
    }

    /**
     * Print the list of error messages at INFO level
     */
    public void printMessagesAsInfo() {
        logger.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        if(messages != null) {
            for (String message : messages) {
                logger.debug(message);
            }
        }
    }

}
