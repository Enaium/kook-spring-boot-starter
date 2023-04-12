/*
 * Copyright 2023 Enaium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.enaium.kookstarter.event;

import java.util.Map;

import static java.util.Map.entry;

/**
 * @author Enaium
 * @since 0.3.0
 */
public class Events {
    public static final Map<String, Class<? extends Event>> EVENTS =
            Map.ofEntries(
                    entry("added_reaction", AddedReaction.class),
                    entry("deleted_reaction", DeletedReaction.class),
                    entry("updated_message", UpdatedMessage.class),
                    entry("deleted_message", DeletedMessage.class),
                    entry("added_channel", AddedChannel.class),
                    entry("updated_channel", UpdatedChannel.class),
                    entry("deleted_channel", DeletedChannel.class),
                    entry("pinned_message", PinnedMessage.class),
                    entry("unpinned_message", UnpinnedMessage.class),
                    entry("updated_private_message", UpdatedPrivateMessage.class),
                    entry("deleted_private_message", DeletedPrivateMessage.class),
                    entry("private_added_reaction", PrivateAddedReaction.class),
                    entry("private_deleted_reaction", PrivateDeletedReaction.class),
                    entry("joined_guild", JoinedGuild.class),
                    entry("exited_guild", ExitedGuild.class),
                    entry("updated_guild_member", UpdatedGuildMember.class),
                    entry("guild_member_online", GuildMemberOnline.class),
                    entry("guild_member_offline", GuildMemberOffline.class),
                    entry("added_role", AddedRole.class),
                    entry("deleted_role", DeletedRole.class),
                    entry("updated_role", UpdatedRole.class),
                    entry("updated_guild", UpdatedGuild.class),
                    entry("deleted_guild", DeletedGuild.class),
                    entry("added_block_list", AddedBlockList.class),
                    entry("deleted_block_list", DeletedBlockList.class),
                    entry("added_emoji", AddedEmoji.class),
                    entry("removed_emoji", RemovedEmoji.class),
                    entry("updated_emoji", UpdatedEmoji.class),
                    entry("joined_channel", JoinedChannel.class),
                    entry("exited_channel", ExitedChannel.class),
                    entry("user_updated", UserUpdated.class),
                    entry("self_joined_guild", SelfJoinedGuild.class),
                    entry("self_exited_guild", SelfExitedGuild.class),
                    entry("message_btn_click", MessageBtnClick.class),
                    entry("text_channel_message_1", TextEvent.class),
                    entry("text_channel_message_2", ImageEvent.class),
                    entry("text_channel_message_3", VideoEvent.class),
                    entry("text_channel_message_4", FileEvent.class),
                    entry("text_channel_message_8", AudioEvent.class),
                    entry("text_channel_message_9", KMarkdownEvent.class),
                    entry("text_channel_message_10", CardEvent.class),
                    entry("text_channel_message_12", ImageAnimationEvent.class)
            );
}
