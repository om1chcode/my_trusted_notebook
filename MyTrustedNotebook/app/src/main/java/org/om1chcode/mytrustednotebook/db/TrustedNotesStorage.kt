package org.om1chcode.mytrustednotebook.db

import android.content.Context
import androidx.room.Room
import org.om1chcode.mytrustednotebook.TrustedNote

class TrustedNotesStorage( context : Context )
{
	private val db = Room.databaseBuilder(context, TrustedNotesDB::class.java, "database" )
		.allowMainThreadQueries()
		.fallbackToDestructiveMigration()
		.build()

	// -----------------------------------------------------------------------------------------------------------------
	fun getTrustedNote( id : Long ) : TrustedNote?
	{
		val entity = db.trustedNotesDao().getTrustedNote( id )
		if( entity != null )
		{
			return TrustedNote( entity.header, entity.text )
		}
		return null
	}

	// -----------------------------------------------------------------------------------------------------------------
	fun deleteTrustedNote( id : Long )
	{
		db.trustedNotesDao().deleteTrustedNote( id )
	}

	// -----------------------------------------------------------------------------------------------------------------
	fun addTrustedNote( note : TrustedNote ) : Long
	{
		val entity = TrustedNoteEntity()
		entity.header = note.header;
		entity.text = note.text;

		return db.trustedNotesDao().insertTrustedNote( entity )
	}

	// -----------------------------------------------------------------------------------------------------------------
	fun getAllTrustedNotes() : List<TrustedNote>
	{
		val list = arrayListOf<TrustedNote>();

		val entities = db.trustedNotesDao().getAllTrustedNotes();
		entities.forEach{  list.add(TrustedNote( it.header, it.text)) }

		return list;
	}
}