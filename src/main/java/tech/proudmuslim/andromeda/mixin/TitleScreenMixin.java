package tech.proudmuslim.andromeda.mixin;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.TranslatableText;
import net.minecraft.text.Text;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgetsNormal")
    private void addCustomButton(int y, int spacingY, CallbackInfo ci) {
        this.addButton(new ButtonWidget(this.width / 2 - 50, y, 250, 75, new TranslatableText("Test"), (buttonWidget) -> {
            this.client.openScreen(new SelectWorldScreen(this));
        }));
    }

}
