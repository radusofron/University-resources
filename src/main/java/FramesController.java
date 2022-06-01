import java.util.concurrent.TimeUnit;

public class FramesController {
   static boolean versionOneSelected = false;
   static boolean versionTwoSelected = false;
   boolean versionIsSelected = false;
   MainFrame mainFrame = new MainFrame();
   VersionOneFrame versionOneFrame = new VersionOneFrame();

        public FramesController() throws InterruptedException {

            mainFrame.setVisible(true);
            waitUntillVersionIsSelected();
            mainFrame.dispose();
            versionOneFrame.setVisible(true);
        }

        public void waitUntillVersionIsSelected() throws InterruptedException {
            while(versionIsSelected == false){
                System.out.println("Version one: " + versionOneSelected);
                System.out.println("Version two: " + versionTwoSelected);
                if(versionOneSelected == true)
                {
                    versionIsSelected = true;
                    System.out.println("Version 1 has been choosen");

                }
                if(versionTwoSelected == true)
                {
                    versionTwoSelected = true;
                    System.out.println("Version 2 has been choosen");
                }

                // this while will check once per 1.5 second
                TimeUnit.MILLISECONDS.sleep(1500);
            }

        }

        private boolean checkVersionOneSelected(){
            if(versionOneSelected == true)
                return true;
            return false;
        }

        private boolean checkVersionTwoSelected(){
            if(versionTwoSelected == true)
                return true;
            return false;
        }
}
