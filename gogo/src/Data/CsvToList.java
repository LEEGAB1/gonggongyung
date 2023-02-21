package Data;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.ColumnType;

import GasStation.GasStation;
import GasStation.GasStationDAO;
import GasStation.GasStationDAOImpl;
import zerozerotwo.dbutil.ConnectionProvider;

public class CsvToList {
	public static void main(String[] args) throws IOException, SQLException {
		String location = "gangseo_gu_gas_station";
		
		CsvSchema schema = new CsvSchema.Builder()//규칙을 설명하는 타임
				
				.addColumn("region", ColumnType.STRING)
				.addColumn("storename", ColumnType.STRING)
				.addColumn("storeaddress", ColumnType.STRING)
				.addColumn("storebrand", ColumnType.STRING)
				.addColumn("storenumber", ColumnType.STRING)
				.addColumn("self", ColumnType.STRING)
				.addColumn("p_gasoline", ColumnType.STRING)
				.addColumn("gasoline", ColumnType.STRING)
				.addColumn("diesel", ColumnType.STRING)
				.addColumn("kerosene", ColumnType.STRING)
				
				
				.build().withHeader().withSkipFirstDataRow(true);// 첫번째 줄에 제목이 있으면 withHeader 없으면 witouthHeader

		MappingIterator<GasStation> iter = new CsvMapper()
				.readerFor(GasStation.class)
				.with(schema)
				.readValues(new File("C:\\Users\\GGG\\git\\gonggongyung\\gogo\\output\\" + location + ".csv"));
		
		List<GasStation> list = iter.readAll();
		System.out.println(list);
		
//		//---------------------------------------------------------------------------------------
//		Connection conn = ConnectionProvider.getConnection();
//		GasStationDAO dao = new GasStationDAOImpl();
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.print(dao.gasStationInsert(conn, list.get(i)));			
//		}
//		
}
}
