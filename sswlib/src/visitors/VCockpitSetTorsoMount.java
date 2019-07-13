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

package visitors;

import components.*;

public class VCockpitSetTorsoMount implements ifVisitor {
    private Mech CurMech;
    LocationIndex[] Locs = null;

    public void SetClan( boolean clan ) {
    }

    public void LoadLocations( LocationIndex[] locs ) {
        Locs = locs;
    }

    public void Visit( Mech m ) throws Exception {
        // Pass us off to the cockpit
        CurMech = m;

        // ensure we're not using a FHES
        if( m.HasFHES() ) {
            throw new Exception( "A 'Mech cannot use a torso-mounted cockpit if it is\nalready using a Full-Head Ejection System." );
        }

        Cockpit c = CurMech.GetCockpit();
        boolean console = m.HasCommandConsole();

        if ( console )
            m.SetCommandConsole(false);

        // first, we have to remove it from the loadout
        ifMechLoadout l = CurMech.GetLoadout();
        c.Remove( l );

        // now set the correct type
        c.SetTorsoMount();

        if ( c.RequiresGyro() && CurMech.GetGyro().NumCrits() == 0 )
            m.Visit(new VGyroSetStandard());

        // replace the cockpit
        if( Locs == null ) {
            // standard placement
            if( ! c.Place(l) ) {
                throw new Exception( "Cannot allocate the Torso-Mounted Cockpit!" );
            }
        } else {
            // specific placement
            if( ! c.Place( l, Locs ) ) {
                throw new Exception( "Cannot allocate the Torso-Mounted Cockpit!" );
            }
        }

        if ( console )
            m.SetCommandConsole(true);
    }

    public void Visit( CombatVehicle v ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( Infantry i ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( SupportVehicle s ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( BattleArmor b ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( Fighter f ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( Spaceship s ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( SpaceStation s ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( ProtoMech p ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( MobileStructure m ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( LargeSupportVehicle l ) throws Exception {
        // does nothing at the moment
    }

    public void Visit( Dropship d ) throws Exception {
        // does nothing at the moment
    }
}
