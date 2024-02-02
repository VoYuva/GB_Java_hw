import java.util.Objects;

public class Laptop {
    private String firmName;
    private String modelName;//name;
    private String cpu;
    private int romMemory;//memory;
    private String gpu;
    private int ramMemory;
    private String os;
    private String typeMatrix;
    private String color;


    public Laptop(String firmName, String modelName, String cpu, int romMemory, String gpu, int ramMemory, String os, String typeMatrix, String color) {
        this.firmName = firmName;
        this.modelName = modelName;
        this.cpu = cpu;
        this.romMemory = romMemory;
        this.gpu = gpu;
        this.ramMemory = ramMemory;
        this.os = os;
        this.typeMatrix = typeMatrix;
        this.color = color;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getROMMemory() {
        return romMemory;
    }

    public void setROMMemory(int romMemory) {
        this.romMemory = romMemory;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getRAMMemory() {
        return ramMemory;
    }
   
    public void setRAMMemory(int ramMemory) {
        this.ramMemory = ramMemory;
    }

    public String getOs() {
        return os;
    }
 
    public void setOs(String os) {
        this.os = os;
    }

    public String getTypeMatrix() {
        return typeMatrix;
    }
 
    public void setTypeMatrix(String typeMatrix) {
        this.typeMatrix = typeMatrix;
    }

    public String getColor() {
        return color;
    }
 
    public void setColor(String color) {
        this.color = color;
    }

    
    public String toString() {
        return  "Название фирмы и модели: '" + firmName + " " + modelName + '\'' +
                ", процессор: " + cpu +
                ", объем памяти: '" + romMemory + '\'' +
                ", видеокарта: '" + gpu + '\'' +
                ", объем оперативной памяти: '" + ramMemory + '\'' +
                ", операционная система: '" + os + '\'' +
                ", тип матрицы: '" + typeMatrix + '\'' +
                ", цвет: '" + color + '\'';
    }


    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return firmName.equals(laptop.firmName) && modelName.equals(laptop.modelName) && cpu.equals(laptop.cpu) && romMemory == laptop.romMemory && gpu.equals(laptop.gpu) && 
        ramMemory == laptop.ramMemory && os.equals(laptop.os) && typeMatrix.equals(laptop.typeMatrix) && color.equals(laptop.color);
    }
    
    public int hashCode() {
        return Objects.hash(firmName, modelName, cpu, romMemory, gpu, ramMemory, os, typeMatrix, color);
    }

}