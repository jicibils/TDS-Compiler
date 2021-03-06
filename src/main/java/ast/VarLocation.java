package main.java.ast;

import main.java.visitor.ASTVisitor;
import java.util.List;
import java.util.LinkedList;

public class VarLocation extends Location {
	private int blockId;
	private List<String> arrayId;		

	public VarLocation(String id,int line,int column) { 		
		this.id = id;
		this.blockId = -1;
		arrayId = new LinkedList<String>();
		this.setLineNumber(line);
		this.setColumnNumber(column);
	}

	public VarLocation(String id,List<String> l,int line,int column) {
		this.id = id;
		this.blockId = -1;
		arrayId = l;
		this.setLineNumber(line);
		this.setColumnNumber(column);	
	}
		
	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	public List<String> getArrayId() {
		return arrayId;
	}

	public void setArrayId(List<String> l) {
		arrayId = l;
	}
	

	@Override
	public String toString() {
		String locString = id;
		for (String arr : arrayId) {
			locString += "." + arr;
		}
		return locString;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
