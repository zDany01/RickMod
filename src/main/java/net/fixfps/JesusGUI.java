package net.fixfps;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;

public class JesusGUI extends LightweightGuiDescription{
    public JesusGUI(){
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(100,100);
    }
}
