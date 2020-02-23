package dao;

import java.util.List;
import java.util.Optional;

import domen.OsnovnoSredstvo;
import exceptions.DataNotPresent;
import exceptions.ValidationException;

public interface DaoOsnovnoSredstvo extends Dao<OsnovnoSredstvo> {
	
	public List<OsnovnoSredstvo> vratiPoNazivu(String naziv);
	public void izlistajTipoveOS();
	public List<OsnovnoSredstvo> vratiPoTipu(String tip) throws DataNotPresent, ValidationException;
	public Optional<OsnovnoSredstvo> vratiPoInventarnomBroju(String invBroj);
	public void proveraTipa(String tip) throws ValidationException;
}
