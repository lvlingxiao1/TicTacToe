package tictactoe;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class GameTree {
	GameTreeNode root;
	
	public GameTree(GameTreeNode root){
		this.root=root;
	}
	
	public GameTree() {
		root=new GameTreeNode();
	}

	public void printToFile() throws IOException {
		OutputStream file = new FileOutputStream("data.txt");
		OutputStream buffer = new BufferedOutputStream(file);
		ObjectOutput output = new ObjectOutputStream(buffer);
		output.writeObject(root);
		output.close();
	}
	
	public void readFromFile() throws IOException, ClassNotFoundException {
		InputStream file = new FileInputStream( "data.txt" );
		InputStream buffer = new BufferedInputStream( file );
		ObjectInput input = new ObjectInputStream ( buffer );
		root = (GameTreeNode)input.readObject();
		input.close();
	}
}
