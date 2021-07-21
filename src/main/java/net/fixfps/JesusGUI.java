package net.fixfps;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.data.Insets;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;

public class JesusGUI extends LightweightGuiDescription{
    public JesusGUI(PlayerEntity playerCHC){
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(200, 100);
        root.setInsets(Insets.ROOT_PANEL);
        
        WLabel label = new WLabel(new LiteralText("Scegli chi respawnare")).setColor(0x87ff9d);
        root.add(label, 2, 0);

        WTextField nicknametxb = new WTextField(new LiteralText("             Nickname here")).setMaxLength(29);
        root.add(nicknametxb,1,1,10,0);
        nicknametxb.setLocation(17,20);

        WButton Respawnbtn = new WButton(new LiteralText("Effettua il miracolo"));
        Respawnbtn.setOnClick(() -> {
            //evento on click bottone
            playerCHC.sendMessage(new LiteralText("Hai resuscitato "+ nicknametxb.getText()), true);
            playerCHC.sendMessage(new LiteralText(playerCHC.getEntityName() + " ha resuscitato "+ nicknametxb.getText()), false);
        });
         root.add(Respawnbtn, 0,3,11,0);
        

        root.validate(this);
    }
}
