/*
 * Copyright 2022 Enaium
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

package cn.enaium.kookstarter.model.event;

import java.util.List;

/**
 * @author Enaium
 * @since 0.4.0
 */
public class Events {
    public static final Event DELETED_REACTION = new Event(ChannelEvent.DeletedReaction.class, "deleted_reaction");
    public static final Event UPDATED_MESSAGE = new Event(ChannelEvent.UpdatedMessage.class, "updated_message");
    public static final Event DELETE_MESSAGE = new Event(ChannelEvent.DeletedMessage.class, "deleted_message");
    public static final Event ADDED_CHANNEL = new Event(ChannelEvent.AddedChannel.class, "added_channel");
    public static final Event PINNED_MESSAGE = new Event(ChannelEvent.PinnedMessage.class, "pinned_message");
    public static final Event UNPINNED_MESSAGE = new Event(ChannelEvent.UnpinnedMessage.class, "unpinned_message");
    public static final Event UPDATED_PRIVATE_MESSAGE = new Event(DirectMessageEvent.UpdatedPrivateMessage.class, "updated_private_message");
    public static final Event DELETED_PRIVATE_MESSAGE = new Event(DirectMessageEvent.DeletedPrivateMessage.class, "deleted_private_message");
    public static final Event PRIVATE_ADDED_REACTION = new Event(DirectMessageEvent.PrivateAddedReaction.class, "private_added_reaction");
    public static final Event PRIVATE_DELETED_REACTION = new Event(DirectMessageEvent.PrivateDeletedReaction.class, "private_deleted_reaction");
    public static final Event UPDATED_GUILD = new Event(GuildEvent.UpdatedGuild.class, "updated_guild");
    public static final Event DELETED_GUILD = new Event(GuildEvent.DeletedGuild.class, "deleted_guild");
    public static final Event ADDED_BLOCK_LIST = new Event(GuildEvent.AddedBlockList.class, "added_block_list");
    public static final Event DELETED_BLOCK_LIST = new Event(GuildEvent.DeletedBlockList.class, "deleted_block_list");
    public static final Event ADDED_EMOJI = new Event(GuildEvent.AddedEmoji.class, "added_emoji");
    public static final Event REMOVED_EMOJI = new Event(GuildEvent.RemovedEmoji.class, "removed_emoji");
    public static final Event UPDATED_EMOJI = new Event(GuildEvent.UpdatedEmoji.class, "updated_emoji");
    public static final Event JOINED_GUILD = new Event(GuildMemberEvent.JoinedGuild.class, "joined_guild");
    public static final Event EXITED_GUILD = new Event(GuildMemberEvent.ExitedGuild.class, "exited_guild");
    public static final Event UPDATED_GUILD_MEMBER = new Event(GuildMemberEvent.UpdatedGuildMember.class, "updated_guild_member");
    public static final Event GUILD_MEMBER_ONLINE = new Event(GuildMemberEvent.GuildMemberOnline.class, "guild_member_online");
    public static final Event GUILD_MEMBER_OFFLINE = new Event(GuildMemberEvent.GuildMemberOffline.class, "guild_member_offline");
    public static final Event ADDED_ROLE = new Event(GuildRoleEvent.AddedRole.class, "added_role");
    public static final Event DELETED_ROLE = new Event(GuildRoleEvent.DeletedRole.class, "deleted_role");
    public static final Event UPDATED_ROLE = new Event(GuildRoleEvent.UpdatedRole.class, "updated_role");
    public static final Event MESSAGE_1 = new Event(MessageEvent.Message1.class, "1");
    public static final Event MESSAGE_2 = new Event(MessageEvent.Message2.class, "2");
    public static final Event MESSAGE_3 = new Event(MessageEvent.Message3.class, "3");
    public static final Event MESSAGE_4 = new Event(MessageEvent.Message4.class, "4");
    public static final Event MESSAGE_9 = new Event(MessageEvent.Message9.class, "9");
    public static final Event MESSAGE_10 = new Event(MessageEvent.Message10.class, "10");
    public static final Event MESSAGE_12 = new Event(MessageEvent.Message12.class, "12");
    public static final Event JOINED_CHANNEL = new Event(UserEvent.JoinedChannel.class, "joined_channel");
    public static final Event EXITED_CHANNEL = new Event(UserEvent.ExitedChannel.class, "exited_channel");
    public static final Event USER_UPDATED = new Event(UserEvent.UserUpdated.class, "user_updated");
    public static final Event SELF_JOINED_GUILD = new Event(UserEvent.SelfJoinedGuild.class, "self_joined_guild");
    public static final Event SELF_EXITED_GUILD = new Event(UserEvent.SelfExitedGuild.class, "self_exited_guild");
    public static final Event MESSAGE_BTN_CLICK = new Event(UserEvent.MessageBtnClick.class, "message_btn_click");

    public static final List<Event> EVENTS = List.of(
            DELETED_REACTION,
            UPDATED_MESSAGE,
            DELETE_MESSAGE,
            ADDED_CHANNEL,
            PINNED_MESSAGE,
            UNPINNED_MESSAGE,
            UPDATED_PRIVATE_MESSAGE,
            DELETED_PRIVATE_MESSAGE,
            PRIVATE_ADDED_REACTION,
            PRIVATE_DELETED_REACTION,
            UPDATED_GUILD,
            DELETED_GUILD,
            ADDED_BLOCK_LIST,
            DELETED_BLOCK_LIST,
            ADDED_EMOJI,
            REMOVED_EMOJI,
            UPDATED_EMOJI,
            JOINED_GUILD,
            EXITED_GUILD,
            UPDATED_GUILD_MEMBER,
            GUILD_MEMBER_ONLINE,
            GUILD_MEMBER_OFFLINE,
            ADDED_ROLE,
            DELETED_ROLE,
            UPDATED_ROLE,
            MESSAGE_1,
            MESSAGE_2,
            MESSAGE_3,
            MESSAGE_4,
            MESSAGE_9,
            MESSAGE_10,
            MESSAGE_12,
            JOINED_CHANNEL,
            EXITED_CHANNEL,
            USER_UPDATED,
            SELF_JOINED_GUILD,
            SELF_EXITED_GUILD,
            MESSAGE_BTN_CLICK
    );
}