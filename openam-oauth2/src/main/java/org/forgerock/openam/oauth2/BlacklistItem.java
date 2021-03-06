/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2016 ForgeRock AS.
 */

package org.forgerock.openam.oauth2;

import org.forgerock.openam.blacklist.BlacklistException;
import org.forgerock.openam.blacklist.Blacklistable;

/**
 * Implementation of the Blacklistable interface used for blacklisting stateless OAuth2 tokens.
 */
public class BlacklistItem implements Blacklistable {

    private static final String TOKEN_PREFIX = "blacklist-oauth2-stateless-";

    private String stableStorageID;

    private long blacklistExpiryTime;

    public BlacklistItem(String statelessTokenId) {
        this(statelessTokenId, 0);
    }

    public BlacklistItem(String statelessTokenId, long blacklistExpiryTime) {
        stableStorageID = TOKEN_PREFIX + statelessTokenId;
        this.blacklistExpiryTime = blacklistExpiryTime;
    }

    @Override
    public String getStableStorageID() {
        return stableStorageID;
    }

    @Override
    public long getBlacklistExpiryTime() throws BlacklistException {
        return blacklistExpiryTime;
    }
}
