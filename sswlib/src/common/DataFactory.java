/*
Copyright (c) 2008~2009, Justin R. Bengtson (poopshotgun@yahoo.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

    * Redistributions of source code must retain the above copyright notice,
        this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright notice,
        this list of conditions and the following disclaimer in the
        documentation and/or other materials provided with the distribution.
    * Neither the name of Justin R. Bengtson nor the names of contributors may
        be used to endorse or promote products derived from this software
        without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package common;

import components.CombatVehicle;
import components.Mech;
import components.Quirk;
import filehandlers.BinaryReader;
import java.io.File;
import java.util.ArrayList;

public class DataFactory {
    // Class file to make data lookups easier and disconnected from the GUI
    Object[][] Equipment = { { null }, { null }, { null }, { null }, { null }, { null }, { null }, { null } };
    EquipmentFactory Equips;
    ArrayList quirks;
    ArrayList ammo,
            weapons,
            physicals,
            equips,
            customs;


    public DataFactory() throws Exception
    {
        BinaryReader b = new BinaryReader();
        ammo = b.ReadAmmo( Constants.AMMOFILE );
        weapons = b.ReadWeapons( Constants.WEAPONSFILE );
        physicals = b.ReadPhysicals( Constants.PHYSICALSFILE );
        equips = b.ReadEquipment( Constants.EQUIPMENTFILE );
        quirks = b.ReadQuirks( Constants.QUIRKSFILE );

        File dataFile;
        try
        {
            dataFile = new File( Constants.CUSTOMWEAPONSFILE );
            if (dataFile.exists()) {
                customs = b.ReadWeapons( Constants.CUSTOMWEAPONSFILE );
                if ( customs.size() > 0 ) weapons.addAll(customs);
            }

            dataFile = new File( Constants.CUSTOMAMMOFILE );
            if ( dataFile.exists() ) {
                customs = b.ReadAmmo( Constants.CUSTOMAMMOFILE );
                if ( customs.size() > 0 ) ammo.addAll(customs);
            }

            dataFile = new File( Constants.CUSTOMEQUIPMENTFILE );
            if ( dataFile.exists() ) {
                customs = b.ReadEquipment( Constants.CUSTOMEQUIPMENTFILE );
                if ( customs.size() > 0 ) equips.addAll(customs);
            }

            dataFile = new File( Constants.CUSTOMPHYSICALSFILE );
            if ( dataFile.exists() ) {
                customs = b.ReadPhysicals( Constants.CUSTOMPHYSICALSFILE );
                if ( customs.size() > 0 ) physicals.addAll(customs);
            }

            dataFile = new File( Constants.CUSTOMQUIRKSFILE );
            if ( dataFile.exists() ) {
                ArrayList<Quirk> c = b.ReadQuirks( Constants.CUSTOMQUIRKSFILE );
                if ( c.size() > 0 ) quirks.addAll(c);
            }
        }
        catch (Exception e)
        {
        }
    }

    public DataFactory( Mech m ) throws Exception {
        this();
        Equips = new EquipmentFactory( weapons, physicals, equips, ammo, m );
    }

    public DataFactory( CombatVehicle v ) throws Exception {
        this();
        Equips = new EquipmentFactory( weapons, physicals, equips, ammo, v );
    }

    public EquipmentFactory GetEquipment() {
        return Equips;
    }

    public ArrayList<Quirk> GetQuirks() {
        return quirks;
    }

    public void Rebuild( Mech m ) {
        Equips.BuildPhysicals( m );
    }

    public void Rebuild( CombatVehicle v ) {
        Equips.BuildPhysicals( v );
    }
}
