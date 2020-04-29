package fr.B4D.socket;

import org.junit.Assert;
import org.junit.Test;

import fr.B4D.bot.B4DException;
import fr.B4D.interaction.chat.Channel;
import fr.B4D.interaction.chat.Message;
import fr.B4D.socket.DofusSocket;
import fr.B4D.socket.SocketType;
import fr.B4D.socket.parser.ChatMessageSocketParser;
import fr.B4D.socket.parser.SocketParser;

public class ChatMessageSocketParserTest {

	@Test
	public void testC5() throws InstantiationException, IllegalAccessException, B4DException {
		byte[] socket = {0x0d, (byte) 0xc5, 0x4b, 0x05, 0x00, 0x21, 0x41, 0x63, 0x68, 0x65, 0x74, 0x65, 0x20, 0x5b, 0x43, 0x68, 0x61, 0x70, 0x65, 0x61, 0x75, 0x20, 0x64, 0x65, 0x20, 0x42, 0x65, 0x6e, 0x20, 0x6c, 0x65, 0x20, 0x52, 0x69, 0x70, 0x61, 0x74, 0x65, 0x5d, 0x5e, (byte) 0xa9, (byte) 0xa6, 0x64, 0x00, 0x08, 0x6f, 0x67, 0x35, 0x6b, 0x73, 0x39, 0x31,	0x73, 0x42, 0x50, 0x3a, (byte) 0xad, (byte) 0xc0, 0x34, (byte) 0x80, 0x00, 0x00, 0x09, 0x4c, 0x61, 0x66, 0x6c, 0x61, 0x69, 0x63, 0x68, 0x65, 0x00, 0x00, 0x08, (byte) 0x96, (byte) 0xfa, (byte) 0xcf};
		
		Assert.assertEquals(SocketType.CHAT_MESSAGE_C5_SOCKET, SocketType.fromSocket(socket));
		
		DofusSocket dofusSocket = new DofusSocket(socket);
		SocketParser<?> parser = dofusSocket.getParser();

		Assert.assertEquals(ChatMessageSocketParser.class, parser.getClass());
		
		Message result = new ChatMessageSocketParser().parse(dofusSocket);
		
		Assert.assertEquals(Channel.BUSINESS, result.getChannel());
		Assert.assertEquals("Laflaiche", result.getPseudo());
		Assert.assertEquals("Achete [Chapeau de Ben le Ripate]", result.getText());
	}
	
	@Test
	public void testCD() throws InstantiationException, IllegalAccessException, B4DException {
		byte[] socket = {0x0d, (byte) 0xcd, 0x5b, 0x05, 0x00, 0x28, 0x61, 0x76, 0x65, 0x6e,
				0x64, 0x72, 0x65, 0x20, (byte) 0xef, (byte) 0xbf, (byte) 0xbc, 0x20, 0x78, 0x20, 0x31, 0x30, 0x32, 0x20, 0x6d, 0x70,
				0x20, 0x6d, 0x6f, 0x69, 0x20, 0x31, 0x31, 0x6d, 0x20, 0x3a, 0x29, 0x20, 0x6f, 0x66, 0x72, 0x65,
				0x20, 0x76, 0x69, 0x74, 0x5e, (byte) 0xa9, (byte) 0xbc, 0x6e, 0x00, 0x08, 0x6b, 0x6b, 0x39, 0x32, 0x69, 0x30,
				0x37, 0x73, 0x42, 0x4f, (byte) 0xdf, (byte) 0x8b, (byte) 0x80, 0x69, 0x00, 0x00, 0x00, 0x05, 0x4e, 0x61, 0x65, 0x68,
				0x6f, 0x00, 0x00, 0x08, 0x70, 0x46, (byte) 0x94, 0x00, 0x01, 0x00, 0x3f, (byte) 0xaa, 0x6d, 0x00, 0x00, (byte) 0xbe,
				(byte) 0x81, (byte) 0xcc, 0x1d, 0x66};

		Assert.assertEquals(SocketType.CHAT_MESSAGE_CD_SOCKET, SocketType.fromSocket(socket));
		
		DofusSocket dofusSocket = new DofusSocket(socket);
		SocketParser<?> parser = dofusSocket.getParser();

		Assert.assertEquals(ChatMessageSocketParser.class, parser.getClass());
		
		Message result = new ChatMessageSocketParser().parse(dofusSocket);
		
		Assert.assertEquals(Channel.BUSINESS, result.getChannel());
		Assert.assertEquals("Naeho", result.getPseudo());
		Assert.assertEquals("avendre ￼ x 102 mp moi 11m :) ofre vit", result.getText());
	}
	
	@Test
	public void testC6() throws InstantiationException, IllegalAccessException, B4DException {
		byte[] socket = {0x0d, (byte) 0xc6, 0x01, 0x0e, 0x05, 0x00, (byte) 0xe8, 0x42, 0x6f, 0x6e,
				0x6a, 0x6f, 0x75, 0x72, 0x73, 0x20, 0x4a, 0x27, 0x65, 0x63, 0x68, 0x61, 0x6e, 0x67, 0x65, 0x20,
				0x32, 0x32, 0x4d, 0x20, 0x73, 0x75, 0x72, 0x20, 0x64, 0x6f, 0x66, 0x75, 0x73, 0x20, 0x72, 0x65,
				0x74, 0x72, 0x6f, 0x20, 0x28, 0x4d, 0x6f, 0x69, 0x29, 0x20, 0x63, 0x6f, 0x6e, 0x74, 0x72, 0x65,
				0x20, 0x32, 0x32, 0x4d, 0x20, 0x69, 0x63, 0x69, 0x20, 0x28, 0x56, 0x6f, 0x75, 0x73, 0x29, 0x20,
				0x76, 0x6f, 0x63, 0x61, 0x6c, 0x20, 0x64, 0x69, 0x73, 0x70, 0x6f, 0x20, 0x65, 0x74, 0x20, 0x70,
				0x6f, 0x73, 0x73, 0x69, 0x62, 0x6c, 0x65, 0x20, 0x64, 0x65, 0x20, 0x63, 0x6f, 0x6e, 0x6e, 0x65,
				0x63, 0x74, 0x65, 0x72, 0x20, 0x6c, 0x65, 0x73, 0x20, 0x32, 0x20, 0x63, 0x6f, 0x6d, 0x70, 0x74,
				0x65, 0x20, 0x65, 0x6e, 0x20, 0x6d, 0x65, 0x6d, 0x65, 0x20, 0x74, 0x65, 0x6d, 0x70, 0x73, 0x20,
				0x70, 0x6f, 0x75, 0x72, 0x20, 0x66, 0x61, 0x69, 0x72, 0x65, 0x20, 0x65, 0x63, 0x68, 0x61, 0x6e,
				0x67, 0x65, 0x20, 0x65, 0x6e, 0x20, 0x64, 0x69, 0x72, 0x65, 0x63, 0x74, 0x20, 0x73, 0x75, 0x72,
				0x20, 0x6c, 0x65, 0x73, 0x20, 0x32, 0x20, 0x73, 0x65, 0x72, 0x76, 0x65, 0x75, 0x72, 0x20, 0x21,
				0x21, 0x20, 0x6d, 0x65, 0x20, 0x6d, 0x70, 0x20, 0x70, 0x6f, 0x75, 0x72, 0x20, 0x70, 0x6c, 0x75,
				0x73, 0x20, 0x64, 0x27, 0x69, 0x6e, 0x66, 0x6f, 0x20, 0x3b, 0x29, 0x20, 0x28, 0x53, 0x65, 0x72,
				0x76, 0x65, 0x75, 0x72, 0x20, 0x65, 0x72, 0x61, 0x74, 0x7a, 0x29, 0x21, 0x21, 0x21, 0x21, 0x21,
				0x21, 0x21, 0x21, 0x21, 0x21, 0x5e, (byte) 0xa9, (byte) 0xd7, 0x61, 0x00, 0x08, 0x33, 0x66, 0x6d, 0x76, 0x38,
				0x6c, 0x32, 0x6d, 0x42, 0x50, 0x34, (byte) 0xf9, (byte) 0x80, 0x34, (byte) 0x80, 0x00, 0x00, 0x05, 0x49, 0x6e, 0x6f,
				0x65, 0x65, 0x00, 0x00, 0x07, 0x1e, (byte) 0xbe, (byte) 0x9e};

		Assert.assertEquals(SocketType.CHAT_MESSAGE_C6_SOCKET, SocketType.fromSocket(socket));
		
		DofusSocket dofusSocket = new DofusSocket(socket);
		SocketParser<?> parser = dofusSocket.getParser();

		Assert.assertEquals(ChatMessageSocketParser.class, parser.getClass());
		
		Message result = new ChatMessageSocketParser().parse(dofusSocket);
		
		Assert.assertEquals(Channel.BUSINESS, result.getChannel());
		Assert.assertEquals("Inoee", result.getPseudo());
		Assert.assertEquals("Bonjours J'echange 22M sur dofus retro (Moi) contre 22M ici (Vous) vocal dispo et possible de connecter les 2 compte en meme temps pour faire echange en direct sur les 2 serveur !! me mp pour plus d'info ;) (Serveur eratz)!!!!!!!!!!", result.getText());
	}
	
	@Test
	public void testCE() throws InstantiationException, IllegalAccessException, B4DException {
		byte[] socket = {0x0d, (byte) 0xce, 0x01, (byte) 0x9b, 0x05, 0x00, 0x1d, (byte) 0xef, (byte) 0xbf, (byte) 0xbc,
				0x20, (byte) 0xef, (byte) 0xbf, (byte) 0xbc, 0x20, (byte) 0xef, (byte) 0xbf, (byte) 0xbc, 0x20, (byte) 0xef, (byte) 0xbf, (byte) 0xbc, 0x20, (byte) 0xef, (byte) 0xbf, (byte) 0xbc,
				0x20, 0x41, 0x56, 0x20, 0x6d, 0x70, 0x20, 0x6d, 0x6f, 0x69, 0x5e, (byte) 0xa9, (byte) 0xd8, 0x2d, 0x00, 0x08,
				0x65, 0x71, 0x61, 0x32, 0x6d, 0x65, 0x39, 0x65, 0x42, 0x16, 0x5b, (byte) 0xd8, 0x03, 0x48, 0x00, 0x00,
				0x00, 0x08, 0x44, 0x65, 0x73, 0x70, 0x65, 0x61, 0x63, 0x65, 0x00, 0x00, 0x04, (byte) 0xf3, (byte) 0xee, (byte) 0xd6,
				0x00, 0x05, 0x00, 0x3f, (byte) 0x8e, 0x6e, 0x00, 0x0b, 0x00};

		Assert.assertEquals(SocketType.CHAT_MESSAGE_CE_SOCKET, SocketType.fromSocket(socket));
		
		DofusSocket dofusSocket = new DofusSocket(socket);
		SocketParser<?> parser = dofusSocket.getParser();

		Assert.assertEquals(ChatMessageSocketParser.class, parser.getClass());
		
		Message result = new ChatMessageSocketParser().parse(dofusSocket);
		
		Assert.assertEquals(Channel.BUSINESS, result.getChannel());
		Assert.assertEquals("Despeace", result.getPseudo());
		Assert.assertEquals("￼ ￼ ￼ ￼ ￼ AV mp moi", result.getText());
	}
}