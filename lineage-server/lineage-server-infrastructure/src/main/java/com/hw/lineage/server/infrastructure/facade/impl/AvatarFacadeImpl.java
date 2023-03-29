package com.hw.lineage.server.infrastructure.facade.impl;

import com.hw.lineage.server.domain.facade.AvatarFacade;
import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.GitHubAvatar;
import com.talanlabs.avatargenerator.layers.backgrounds.RandomColorPaintBackgroundLayer;
import org.springframework.stereotype.Service;

/**
 * @description: AvatarFacadeImpl
 * @author: HamaWhite
 */
@Service("avatarFacade")
public class AvatarFacadeImpl implements AvatarFacade {

    @Override
    public byte[] generateAvatar(long code) {
        Avatar avatar = GitHubAvatar.newAvatarBuilder()
                .layers(new RandomColorPaintBackgroundLayer())
                .build();
        return avatar.createAsPngBytes(code);
    }
}
