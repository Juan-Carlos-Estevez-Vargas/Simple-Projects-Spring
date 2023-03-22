package com.gestion.empleados.util.reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gestion.empleados.entities.Empleado;

public class EmpleadoExporterExcel {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;
	private List<Empleado> listaEmpleados;

	public EmpleadoExporterExcel(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Empleados");
	}

	/**
	 * Genera la cabecera de la tabla del reporte en Excel a general; esto se
	 * realiza utilizando las clases de Apache-POI.
	 */
	private void escribirCabeceraTabla() {
		Row fila = hoja.createRow(0);

		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);

		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);

		celda = fila.createCell(1);
		celda.setCellValue("Nombre");
		celda.setCellStyle(estilo);

		celda = fila.createCell(2);
		celda.setCellValue("Apellido");
		celda.setCellStyle(estilo);

		celda = fila.createCell(3);
		celda.setCellValue("Email");
		celda.setCellStyle(estilo);

		celda = fila.createCell(4);
		celda.setCellValue("Fecha");
		celda.setCellStyle(estilo);

		celda = fila.createCell(5);
		celda.setCellValue("Teléfono");
		celda.setCellStyle(estilo);

		celda = fila.createCell(6);
		celda.setCellValue("Sexo");
		celda.setCellStyle(estilo);

		celda = fila.createCell(7);
		celda.setCellValue("Salario");
		celda.setCellStyle(estilo);
	}

	/**
	 * Genera una tabla con los registros traidos de la base de datos.
	 */
	private void escribirDatosTabla() {
		int numeroFilas = 1;

		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);

		for (Empleado empleado : listaEmpleados) {
			Row fila = hoja.createRow(numeroFilas++);

			Cell celda = fila.createCell(0);
			celda.setCellValue(empleado.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);

			celda = fila.createCell(1);
			celda.setCellValue(empleado.getNombre());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);

			celda = fila.createCell(2);
			celda.setCellValue(empleado.getApellido());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

			celda = fila.createCell(3);
			celda.setCellValue(empleado.getEmail());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

			celda = fila.createCell(4);
			celda.setCellValue(empleado.getFecha().toString());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);

			celda = fila.createCell(5);
			celda.setCellValue(empleado.getTelefono());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);

			celda = fila.createCell(6);
			celda.setCellValue(empleado.getSexo());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);

			celda = fila.createCell(7);
			celda.setCellValue(empleado.getSalario());
			hoja.autoSizeColumn(7);
			celda.setCellStyle(estilo);
		}
	}

	/**
	 * Exporta y genera el archivo en Excel; también escribe el libro y lo cierra
	 * junto al flujo de salida.
	 * 
	 * @param response
	 * @throws IOException
	 */
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraTabla();
		escribirDatosTabla();

		ServletOutputStream outputStream = response.getOutputStream();
		libro.write(outputStream);
		libro.close();
		outputStream.close();
	}

}
