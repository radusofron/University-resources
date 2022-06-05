import java.util.concurrent.TimeUnit;

public class FramesController {
   static boolean versionOneSelected = false;
   static boolean versionTwoSelected = false;
   boolean versionIsSelected = false;
   MainFrame mainFrame = new MainFrame();
   VersionOneFrame versionOneFrame = new VersionOneFrame();
   VersionTwoFrame versionTwoFrame = new VersionTwoFrame();

        public FramesController() throws InterruptedException {

            mainFrame.setVisible(true);
            /* wait untill a version is selected */
            waitUntillVersionIsSelected();
            /* close this frame and create a correspondent frame for the selected version */
            mainFrame.dispose();
            if(versionOneSelected == true)
            {
                versionOneFrame.setVisible(true);
            }
            if(versionTwoSelected == true)
            {
                versionTwoFrame.setVisible(true);
            }
        }

        public void waitUntillVersionIsSelected() throws InterruptedException {

            while(versionIsSelected == false){
                if(versionOneSelected == true)
                {
                    versionIsSelected = true;

                }
                if(versionTwoSelected == true)
                {
                    versionIsSelected = true;
                }

                // this while will check once per 1 second
                TimeUnit.MILLISECONDS.sleep(1000);
            }

        }
}
