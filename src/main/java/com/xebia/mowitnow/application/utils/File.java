package com.xebia.mowitnow.application.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.xebia.mowitnow.application.exception.IncorectFormatCoordinatesOrientationException;
import com.xebia.mowitnow.application.exception.IncorectFormatInstructionException;
import com.xebia.mowitnow.application.exception.IncorectFormatMaximalCoordinatesException;
import com.xebia.mowitnow.application.exception.IncorrectFileException;
import com.xebia.mowitnow.application.model.Coordinates;
import com.xebia.mowitnow.application.model.Instruction;
import com.xebia.mowitnow.application.model.Mower;
import com.xebia.mowitnow.application.model.Orientation;

/**
 * Class util for reading a input file.
 * 
 * @author Michel
 * 
 */
public class File {

	private File(){
		
	}
	
	/**
	 * Retrieve all mowers from an input file.
	 * 
	 * @param path
	 * @return list of mowers
	 * @throws IncorectFormatCoordinatesOrientationException
	 * @throws IncorectFormatInstructionException
	 * @throws IncorrectFileException
	 * @throws IncorectFormatMaximalCoordinatesException
	 */
	public static List<Mower> getMowerList(Path path) throws IncorectFormatCoordinatesOrientationException, IncorectFormatInstructionException, IncorrectFileException, IncorectFormatMaximalCoordinatesException {
		
		List<Mower> mowers;
		String line = null;
		
      	try (final BufferedReader reader = Files.newBufferedReader(
             path, Charset.forName("UTF-8"))) {
			
			mowers = new ArrayList<Mower>();
			
			//Pass Trought the first line
			reader.readLine();
			
			while ((line=reader.readLine())!=null){
				
				Mower mower = new Mower();
				setCoordinatesAndOrientation(mower, line);
				
				if((line = reader.readLine())==null){
					throw new IncorectFormatInstructionException ("Instructions missing for mower : " + mower.getCoordinates() + " " + mower.getOrientation());
				}
				
				setInstructions(mower, line);
				mowers.add(mower);
			}
		}		
		
		catch (IOException e){
			throw new IncorrectFileException(e.getMessage());
		}

		return mowers;
	}

	/**
	 * Set all mower's instructions.
	 * 
	 * @param mower
	 * @param line
	 * @throws IncorectFormatInstructionException
	 */
	private static void setInstructions(Mower mower, String line) throws IncorectFormatInstructionException{

		String [] instructions = line.split("");
		
		for (String instruction : instructions){
			if (!EnumUtils.isValidEnum(Instruction.class, instruction)){
				throw new IncorectFormatInstructionException ("Instructions : " +line + " are incorrect ");
			}
			mower.addInstruction(Instruction.valueOf(instruction));
		}
	}
	
	/**
	 * Set mower's orientation and coordinates.
	 * 
	 * @param mower
	 * @param line
	 * @throws IncorectFormatCoordinatesOrientationException
	 * @throws IncorectFormatMaximalCoordinatesException
	 */
	private static void setCoordinatesAndOrientation (Mower mower, String line) throws IncorectFormatCoordinatesOrientationException, IncorectFormatMaximalCoordinatesException{ 
		String [] inputs = line.split(" ");
		
		if(inputs.length !=3 || !NumberUtils.isNumber(inputs[0]) || !NumberUtils.isNumber(inputs[1]) 
				|| !EnumUtils.isValidEnum(Orientation.class, inputs[2])){
			
			throw new IncorectFormatCoordinatesOrientationException("Coordinates : "+ line + " are incorrect");
		}

		Coordinates coordinates = new Coordinates();
		
		coordinates.setX(Integer.valueOf(inputs[0]));
		coordinates.setY(Integer.valueOf(inputs[1]));
		mower.setCoordinates(coordinates);
		mower.setOrientation(Orientation.valueOf(inputs[2]));
		
	}

	/**
	 * Get coordinates max from input file.
	 * 
	 * @param path
	 * @return coordinates
	 * @throws IncorectFormatMaximalCoordinatesException
	 * @throws IncorrectFileException
	 */
	public static Coordinates getGroundMaxCoordinates(Path path) throws  IncorectFormatMaximalCoordinatesException, IncorrectFileException {

      try (final BufferedReader reader = Files.newBufferedReader(
    		  path, Charset.forName("UTF-8"))) {

			String line = reader.readLine();
			reader.close(); 
			
			if (line==null){
				throw new IncorrectFileException("The File is empty");
			}
			
			Coordinates coordinates = retrieveCoordinatesMax(line);
			
			return coordinates;
			
		}catch (IOException e){
			throw new IncorrectFileException (e.getMessage());
		}		

	}
	
	/**
	 * Retrieve coordinates max
	 * 
	 * @param line
	 * @return Coordinates
	 * @throws IncorectFormatMaximalCoordinatesException
	 */
	private static Coordinates retrieveCoordinatesMax(String line) throws IncorectFormatMaximalCoordinatesException{

		String [] inputs = line.split(" ");
		
		if(inputs.length !=2 || !NumberUtils.isNumber(inputs[0]) || !NumberUtils.isNumber(inputs[1])){
			throw new IncorectFormatMaximalCoordinatesException("Max coordinates numbers are incorrects");
		}
		
		Coordinates coordinates = new Coordinates();

		coordinates.setX(Integer.valueOf(inputs[0]));
		coordinates.setY(Integer.valueOf(inputs[1]));
		
		return coordinates;
		
	}
}
